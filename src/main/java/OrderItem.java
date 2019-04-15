import javax.persistence.*;

@Entity
public class OrderItem
{
    private int quantity;
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Order order;
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Item item;
    public Item getItem() { return item; }
    public void setItem(User user) { this.item = item; }
}
