import java.util.List;

public interface IDataStore<T>
{
    void createItem(T item);
    void updateItem(T user);
    void deleteItem(T user);
    T getItem(int id);
    List<T> getAllItems();
}