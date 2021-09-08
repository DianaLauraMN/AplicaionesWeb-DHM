package daos;


import businessObjects.Municipality;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MunicipalityDAO implements DAO<Municipality> {

     MongoCollection<Municipality> collection = instance.getConnection().getCollection("Municipalities", Municipality.class);

    @Override
    public boolean insert(Municipality item) {
        try{
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Municipality> findLike(String pattern) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Municipality> findMany(int many) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
