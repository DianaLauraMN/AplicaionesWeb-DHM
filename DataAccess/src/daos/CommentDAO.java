package daos;

import businessObjects.Comment;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class CommentDAO implements DAO<Comment> {

    MongoCollection<Comment> collection = instance.getConnection().getCollection("Comments", Comment.class);

    @Override
    public boolean insert(Comment item) {
        try {
            collection.insertOne(item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(ObjectId idItem) {
        try {
            collection.deleteOne(eq("_id", idItem));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteItem(ObjectId idItem, ObjectId idDelete) {

        Comment comments = null;
        try {
            int x = -1;
            comments = collection.find(eq("_id", idItem)).first();
            List<ObjectId> idComments = comments.getComments();
            for (int i = 0; i < idComments.size(); i++) {
                if (idDelete.equals(idComments.get(i))) {
                    x = i;
                    break;
                }
            }
            idComments.remove(x);
            comments.setComments(idComments);
            update(comments);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Comment item) {
        try {
            collection.updateOne(eq("_id", item.getId()), new Document("$set",
                    new Document().append("dateTime", item.getDateTime()).append("content",
                            item.getContent()).append("comments", item.getComments())));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Comment find(ObjectId id) {
        try {
            return collection.find(eq("_id", id)).first();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new Comment();
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = new ArrayList<>();
        try {
            collection.find().into(comments);
        } catch (Exception ex) {
            return null;
        }
        return comments;
    }

    @Override
    public List<Comment> findLike(String pattern) {

        ArrayList<Comment> comments = new ArrayList<>();
        try {
            if (pattern.equalsIgnoreCase("")) {
                return findAll();
            } else {
                collection.find(regex("content", pattern, "i")).into(comments);
            }
        } catch (Exception ex) {
            return null;
        }
        return comments;
    }

    @Override
    public List<Comment> findMany(int many) {
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            collection.find().limit(many).into(comments);
        } catch (Exception ex) {
            return null;
        }
        return comments;
    }

}
