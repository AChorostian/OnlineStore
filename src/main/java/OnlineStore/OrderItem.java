package OnlineStore;

import javax.persistence.*;

@Entity
public class OrderItem implements IDataElement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
