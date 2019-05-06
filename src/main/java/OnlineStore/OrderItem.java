package OnlineStore;

import javax.persistence.*;

@Entity
public class OrderItem implements IDataElement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Order order;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Item item;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public Item getItem() { return item; }
    public void setItem(User user) { this.item = item; }
}
