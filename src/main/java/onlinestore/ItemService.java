package onlinestore;

import java.util.ArrayList;
import java.util.List;

public class ItemService
{
    private IDataStore<Item> dataStore;

    public void setDataStore(IDataStore<Item> dataStore)
    {
        this.dataStore = dataStore;
    }

    public void createItem(String name, Double price)
    {
        if (wrong(name,price))
            throw new IllegalArgumentException();
        Item newItem = new Item();
        newItem.setName(name);
        newItem.setPrice(price);
        dataStore.createItem(newItem);
    }

    public List<Item> getAllItems()
    {
        return dataStore.getAllItems();
    }

    public void updateItem(Item item)
    {
        if (item == null)
            throw new IllegalArgumentException();
        if (wrong(item.getName(),item.getPrice()))
            throw new IllegalArgumentException();
        dataStore.updateItem(item);
    }

    public void deleteItem(Item item)
    {
        dataStore.deleteItem(item);
    }

    public List<Item> findItemByName(String name)
    {
        List<Item> result = new ArrayList<>();
        for(Item item : dataStore.getAllItems())
        {
            if (item.getName().equals(name))
                result.add(item);
        }
        return result;
    }

    public List<Item> findItemByDouble(Double price)
    {
        List<Item> result = new ArrayList<>();
        for(Item item : dataStore.getAllItems())
        {
            if (item.getPrice().equals(price))
                result.add(item);
        }
        return result;
    }

    private boolean wrong(String name, Double price)
    {
        boolean correct = true;
        if (name == null)
            correct = false;
        else
            if (name.length() > 30 || name.length() == 0)
                correct = false;
        if (price == null)
            correct = false;
        else
            if (price < 0) // free items possible
                correct = false;
        return !correct;
    }
}
