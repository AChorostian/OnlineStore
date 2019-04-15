import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Init
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int id;

    private String name;
}
