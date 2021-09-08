package daos;


import businessObjects.Post;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class PostDAO implements DAO<Post> {

     MongoCollection<Post> collection = instance.getConnection().getCollection("Posts", Post.class);

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            System.out.println(ex.getMessage());
        }
        return post;
    }

    @Override
    public List<Post> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> findLike(String pattern) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> findMany(int many) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
