
package daos;

import java.util.List;
import org.bson.types.ObjectId;


public interface DAO <T>{
    public boolean insert(T intem);
    public boolean delete(ObjectId idItem);
    public boolean deleteItem(ObjectId idItem, ObjectId idDelete);
    public boolean update(T item);
    public T find(ObjectId id);
    public List<T> findAll();
    public List<T> findLike(String pattern);
    public List<T> findMany(int many);
   
}
