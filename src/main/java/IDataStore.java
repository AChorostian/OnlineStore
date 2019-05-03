import java.util.List;

public interface IDataStore<T>
{
    void createItem(T item);
    void updateItem(T user);
    void deleteItem(T user);
    T getItem(Long id);
    List<T> getAllItems();
}