
package interfaces;


public interface DAO <T>{
    public boolean insert(T intem);
    public boolean delete(int idItem);
    public boolean deleteItem(int idItem, int idDelete);
    public boolean update(T item);
   
}
