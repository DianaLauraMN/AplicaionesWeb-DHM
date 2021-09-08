
package daos;

import businessObjects.Comment;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
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
        }
        return true;
    }

    @Override
    public boolean deleteItem(ObjectId idItem, ObjectId idDelete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Comment item) {
        try {
            collection.updateOne(eq("_id", item.getId()), new Document("$set",
                    new Document().append("dateTime", item.getDateTime()).append("content",
                            item.getContent()).append("comments", item.getComments())));
        } catch (Exception e) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comment> findLike(String pattern) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comment> findMany(int many) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
