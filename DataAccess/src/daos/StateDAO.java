package daos;

import businessObjects.State;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import static daos.DAO.instance;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.bson.Document;

public class StateDAO implements DAO<State> {

    MongoCollection<State> collection = instance.getConnection().getCollection("states", State.class);

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
        State states = null;
        try {
            int x = -1;
            states = collection.find(eq("_id", idItem)).first();
            List<ObjectId> idMunicipalities = states.getMunicipalities();
            for (int i = 0; i < idMunicipalities.size(); i++) {
                if (idDelete.equals(idMunicipalities.get(i))) {
                    x = i;
                    break;
                }
            }
            idMunicipalities.remove(x);
            states.setMunicipalities(idMunicipalities);
            update(states);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
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
        ArrayList<State> states = new ArrayList<>();
        try {
            collection.find().into(states);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return states;
    }

    @Override
    public List<State> findLike(String pattern) {
        ArrayList<State> states = new ArrayList<>();
        try {
            if (pattern.equalsIgnoreCase("")) {
                return findAll();
            } else {
                collection.find(regex("name", pattern, "i")).into(states);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return states;
    }

    @Override
    public List<State> findMany(int many) {
        ArrayList<State> states = new ArrayList<>();
        try {
            collection.find().limit(many).into(states);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return states;
    }

}
