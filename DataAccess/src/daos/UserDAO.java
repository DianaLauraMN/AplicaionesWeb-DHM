package daos;

import businessObjects.Administrator;
import businessObjects.Normal;
import businessObjects.User;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class UserDAO implements DAO<User> {

    MongoCollection<User> collection = instance.getConnection().getCollection("Users", User.class);
    MongoCollection<Normal> normals = instance.getConnection().getCollection("Users", Normal.class);
    MongoCollection<Administrator> admins = instance.getConnection().getCollection("Users", Administrator.class);

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
        return false;
    }

    @Override
    public boolean update(User item) {

        try {
            collection.updateOne(eq("_id", item.getId()), new Document("$set",
                    new Document().append("fullName", item.getFullName())
                            .append("phoneNumber", item.getPhoneNumber()).append("email",
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
        User user = null;
        try {
            user = collection.find(eq("_id", id)).first();
        } catch (Exception ex) {
            try {
                user = normals.find(eq("_id", id)).first();
            } catch (Exception e) {
                user = admins.find(eq("_id", id)).first();
            }
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            collection.find().into(users);
        } catch (Exception ex) {
            try {
                normals.find().into(users);
            } catch (Exception e) {
                admins.find().into(users);
            }
        }
        return users;
    }

    @Override
    public List<User> findLike(String pattern) {
        ArrayList<User> users = new ArrayList<>();
        try {
            if (pattern.equalsIgnoreCase("")) {
                return findAll();
            } else {
                collection.find(regex("avatar", pattern, "i")).into(users);
            }
        } catch (Exception ex) {
            try {
                normals.find(regex("avatar", pattern, "i")).into(users);

            } catch (Exception e) {
                admins.find(regex("avatar", pattern, "i")).into(users);

            }
        }
        return users;

    }

    @Override
    public List<User> findMany(int many) {
        ArrayList<User> users = new ArrayList<>();
        try {
            collection.find().limit(many).into(users);
        } catch (Exception ex) {
            try {
                normals.find().limit(many).into(users);
            } catch (Exception e) {
                admins.find().limit(many).into(users);
            }
        }
        return users;
    }

}
