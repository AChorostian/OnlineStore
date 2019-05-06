package OnlineStore;

import javax.persistence.*;

@Entity
public class Order implements IDataElement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
