package daos;

import businessObjects.State;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.List;
import org.bson.types.ObjectId;
import org.bson.Document;

public class StateDAO implements DAO<State> {

    MongoCollection<State> collection = instance.getConnection().getCollection("States", State.class);

    @Override
    public boolean insert(State item) {
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
    public boolean update(State item) {
        try {

            collection.updateOne(eq("_id", item.getId()), new Document("$set",
                    new Document().append("name", item.getName()).append("municipalities", item.getMunicipalities())));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public State find(ObjectId id) {
        State state = null;
        try {

            state = collection.find(eq("_id", id)).first();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return state;
    }

    @Override
    public List<State> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> findLike(String pattern) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> findMany(int many) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
