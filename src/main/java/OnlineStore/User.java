package OnlineStore;

import javax.persistence.*;

@Entity
public class User implements IDataElement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    private String firstName;
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    private String lastName;
    public String getLastName() { return lastName; }
    public void setLastName(String lastName)
    { this.lastName = lastName; }

    private String eMail;
    public String getEMail() { return eMail; }
    public void setEMail(String eMail) { this.eMail = eMail; }
}
