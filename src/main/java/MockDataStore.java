import java.util.List;

public class MockDataStore implements IDataStore
{
    private List<IDataElement> items;

    public void createItem(IDataElement item)
    {
        items.add(item);
    }

    public void updateItem(IDataElement item)
    {
        for (IDataElement i : items)
        {
            if (i.getId().equals(item.getId()))
            {
                items.remove(i);
            }
        }
        items.add(item);
    }

    public void deleteItem(IDataElement item)
    {
        for (IDataElement i : items)
        {
            if (i.getId().equals(item.getId()))
            {
                items.remove(i);
            }
        }
    }

    public List<IDataElement> getAllItems()
    {
        return items;
    }
}
