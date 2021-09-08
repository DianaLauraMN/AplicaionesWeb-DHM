package daos;

import daos.DAO;
import businessObjects.User;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class UserDAO implements DAO<User> {

    MongoCollection<User> collection = instance.getConnection().getCollection("Users", User.class);

    @Override
    public boolean insert(User intem) {
        try {
            collection.insertOne(intem);
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
    public boolean update(User item) {

        try {
            collection.updateOne(eq("_id", item.getId()), new Document("$set",
                    new Document().append("fullName", item.getFullName()).append("email",
                            item.getEmail()).append("password", item.getPassword()).append("avatar",
                            item.getAvatar()).append("city", item.getCity()).append("birthDay",
                            item.getBirthDay()).append("gender", item.getGender())));
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    @Override
    public User find(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findLike(String pattern) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findMany(int many) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
