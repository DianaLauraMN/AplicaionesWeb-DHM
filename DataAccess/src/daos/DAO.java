
package daos;

import database.DataBase;
import database.DataBase;
import java.util.List;
import org.bson.types.ObjectId;


public interface DAO <T>{
   
    public static DataBase instance = DataBase.INSTACE;
    
    public boolean insert(T item);
    public boolean delete(ObjectId idItem);
    public boolean deleteItem(ObjectId idItem, ObjectId idDelete);
    public boolean update(T item);
    public T find(ObjectId id);
    public List<T> findAll();
    public List<T> findLike(String pattern);
    public List<T> findMany(int many);
   
}
