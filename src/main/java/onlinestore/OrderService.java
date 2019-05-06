package onlinestore;

import java.util.ArrayList;
import java.util.List;

public class OrderService
{
    private IDataStore<Order> dataStore;

    public void setDataStore(IDataStore<Order> dataStore)
    {
        this.dataStore = dataStore;
    }

    public void createOrder(User user)
    {
        if (user == null)
            throw new IllegalArgumentException();
        Order newOrder = new Order();
        newOrder.setUser(user);
        dataStore.createItem(newOrder);
    }

    public List<Order> getAllUsers()
    {
        return dataStore.getAllItems();
    }

    public void updateOrder(Order order)
    {
        if (order.getUser() == null)
            throw new IllegalArgumentException();
        dataStore.updateItem(order);
    }

    public void deleteUser(Order order)
    {
        dataStore.deleteItem(order);
    }

    public List<Order> findOrderByUser(User user)
    {
        List<Order> result = new ArrayList<>();
        for(Order order : dataStore.getAllItems())
        {
            if (order.getUser().equals(user))
                result.add(order);
        }
        return result;
    }
}
