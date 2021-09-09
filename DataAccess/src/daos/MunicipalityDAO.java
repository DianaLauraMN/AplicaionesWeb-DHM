package daos;

import businessObjects.Municipality;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MunicipalityDAO implements DAO<Municipality> {

    MongoCollection<Municipality> collection = instance.getConnection().getCollection("Municipalities", Municipality.class);


    @Override
    public boolean insert(Municipality item) {
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
        Municipality municipality = null;
        try {
            int x = -1;
            municipality = collection.find(eq("_id", idItem)).first();
            List<ObjectId> idUsers = municipality.getUsers();
            for (int i = 0; i < idUsers.size(); i++) {
                if (idDelete.equals(idUsers.get(i))) {
                    x = i;
                    break;
                }
            }
            idUsers.remove(x);
            municipality.setUsers(idUsers);
            update(municipality);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean update(Municipality item) {
        try {

            collection.updateOne(eq("_id", item.getId()), new Document("$set",
                    new Document().append("name", item.getName()).append("users", item.getUsers())));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public Municipality find(ObjectId id) {
        Municipality municipality = null;
        try {

            municipality = collection.find(eq("_id", id)).first();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return municipality;
    }

    @Override
    public List<Municipality> findAll() {
        ArrayList<Municipality> municipalities = new ArrayList<>();
        try {
            collection.find().into(municipalities);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return municipalities;
    }

    @Override
    public List<Municipality> findLike(String pattern) {
        ArrayList<Municipality> municipalities = new ArrayList<>();
        try {
            if (pattern.equalsIgnoreCase("")) {
                return findAll();
            } else {
                collection.find(regex("name", pattern, "i")).into(municipalities);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return municipalities;
    }

    @Override
    public List<Municipality> findMany(int many) {
        ArrayList<Municipality> municipalities = new ArrayList<>();
        try {
            collection.find().limit(many).into(municipalities);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return municipalities;
    }
}
