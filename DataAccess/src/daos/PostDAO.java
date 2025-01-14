package daos;

import businessObjects.Anchored;
import businessObjects.Common;
import businessObjects.Post;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import static daos.DAO.instance;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class PostDAO implements DAO<Post> {

    MongoCollection<Post> collection = instance.getConnection().getCollection("Posts", Post.class);
    MongoCollection<Anchored> anchores = instance.getConnection().getCollection("Posts", Anchored.class);
    MongoCollection<Common> commons = instance.getConnection().getCollection("Posts", Common.class);

    @Override
    public boolean insert(Post item) {
        try {

            collection.insertOne(item);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(ObjectId idItem) {
        try {

            collection.deleteOne(eq("_id", idItem));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteItem(ObjectId idItem, ObjectId idDelete) {
        Post posts = null;
        try {
            int x = -1;
            posts = collection.find(eq("_id", idItem)).first();
            List<ObjectId> idComments = posts.getComments();
            for (int i = 0; i < idComments.size(); i++) {
                if (idDelete.equals(idComments.get(i))) {
                    x = i;
                    break;
                }
            }
            idComments.remove(x);
            posts.setComments(idComments);
            update(posts);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean update(Post item) {
        try {

            collection.updateOne(eq("_id", item.getId()), new Document("$set",
                    new Document().append("idUser", item.getIdUser()).append("dateCreation", item.getDateTimeCreation()).append("title", item.getTitle()).append("content", item.getContent())
                            .append("dateEdition", item.getDateTimeEdition()).append("comments", item.getComments())));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public Post find(ObjectId id) {
        Post post = null;
        try {
            post = collection.find(eq("_id", id)).first();
        } catch (Exception ex) {

            try {
                post = anchores.find(eq("_id", id)).first();

            } catch (Exception e) {
                post = commons.find(eq("_id", id)).first();

            }
        }
        return post;
    }

    @Override
    public List<Post> findAll() {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            collection.find().into(posts);
        } catch (Exception ex) {
            try {
                anchores.find().into(posts);

            } catch (Exception e) {
                commons.find().into(posts);

            }
        }
        return posts;
    }

    @Override
    public List<Post> findLike(String pattern) {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            if (pattern.equalsIgnoreCase("")) {
                return findAll();
            } else {
                collection.find(regex("title", pattern, "i")).into(posts);
            }
        } catch (Exception ex) {
            try {
                anchores.find(regex("title", pattern, "i")).into(posts);

            } catch (Exception e) {
                commons.find(regex("title", pattern, "i")).into(posts);

            }
        }
        return posts;
    }

    @Override
    public List<Post> findMany(int many) {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            collection.find().limit(many).into(posts);
        } catch (Exception ex) {

            try {
                anchores.find().limit(many).into(posts);

            } catch (Exception e) {
                commons.find().limit(many).into(posts);

            }
        }
        return posts;
    }

}
