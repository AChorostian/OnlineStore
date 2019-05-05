import java.util.List;

public interface IDataStore
{
    void createItem(IDataElement item);
    void updateItem(IDataElement user);
    void deleteItem(IDataElement user);
    List<IDataElement> getAllItems();
}