import javax.persistence.*;

@Entity
public class Item implements IDataElement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private Double price;
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
