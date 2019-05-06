package onlinestore;

import java.util.ArrayList;
import java.util.List;

public class MockDataStore<T extends IDataElement> implements IDataStore<T>
{
    private List<T> items;
    private Long counter;

    MockDataStore()
    {
        items = new ArrayList<>();
        counter = 0L;
    }

    public void createItem(T item)
    {
        item.setId(counter++);
        items.add(item);
    }

    public void updateItem(T item)
    {
        int indexToDelete=-1;
        for (T i : items)
        {
            if (i.getId().equals(item.getId()))
            {
                indexToDelete = items.indexOf(i);
            }
        }
        items.remove(indexToDelete);
        items.add(item);
    }

    public void deleteItem(T item)
    {
        int indexToDelete=-1;
        for (T i : items)
        {
            if (i.getId().equals(item.getId()))
            {
                indexToDelete = items.indexOf(i);
            }
        }
        items.remove(indexToDelete);
    }

    public List<T> getAllItems()
    {
        return items;
    }
}
