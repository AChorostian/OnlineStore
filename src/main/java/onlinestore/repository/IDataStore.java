package onlinestore.repository;

import java.util.List;

public interface IDataStore<T extends IDataElement>
{
    void createItem(T item);
    void updateItem(T user);
    void deleteItem(T user);
    List<T> getAllItems();
}