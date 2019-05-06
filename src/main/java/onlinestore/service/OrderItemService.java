package onlinestore.service;

import onlinestore.entity.*;
import onlinestore.repository.IDataStore;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService
{
    private IDataStore<OrderItem> dataStore;

    public void setDataStore(IDataStore<OrderItem> dataStore)
    {
        this.dataStore = dataStore;
    }

    public void createOrderItem(int quantity, Order order, Item item)
    {
        if (order == null || item == null || quantity < 1)
            throw new IllegalArgumentException();
        OrderItem newOrderItem = new OrderItem();
        newOrderItem.setQuantity(quantity);
        newOrderItem.setOrder(order);
        newOrderItem.setItem(item);
        dataStore.createItem(newOrderItem);
    }

    public List<OrderItem> getAllOrderItems()
    {
        return dataStore.getAllItems();
    }

    public void updateOrderItem(OrderItem orderItem)
    {
        if (orderItem.getOrder() == null || orderItem.getItem() == null || orderItem.getQuantity() < 1)
            throw new IllegalArgumentException();
        dataStore.updateItem(orderItem);
    }

    public void deleteOrderItem(OrderItem orderItem)
    {
        dataStore.deleteItem(orderItem);
    }

    public List<OrderItem> findOrderItemByQuantity(int quantity)
    {
        List<OrderItem> result = new ArrayList<>();
        for(OrderItem orderItem : dataStore.getAllItems())
        {
            if (orderItem.getQuantity() == quantity)
                result.add(orderItem);
        }
        return result;
    }

    public List<OrderItem> findOrderItemByOrder(Order order)
    {
        List<OrderItem> result = new ArrayList<>();
        for(OrderItem orderItem : dataStore.getAllItems())
        {
            if (orderItem.getOrder().equals(order))
                result.add(orderItem);
        }
        return result;
    }

    public List<OrderItem> findOrderItemByItem(Item item)
    {
        List<OrderItem> result = new ArrayList<>();
        for(OrderItem orderItem : dataStore.getAllItems())
        {
            if (orderItem.getItem().equals(item))
                result.add(orderItem);
        }
        return result;
    }
}
