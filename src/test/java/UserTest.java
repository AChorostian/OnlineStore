import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest
{
    private IDataStore<User> ds;
    private UserService us;

    @BeforeEach
    void setup()
    {
        ds = new MockDataStore<>();
        us = new UserService();
        us.setDataStore(ds);
    }

    @Test
    void createUserTest()
    {
        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
        assertEquals(1, us.getAllUsers().size());
    }

    @Test
    void findUserByNameNotNullTest()
    {
        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
        assertNotNull(us.findUserByFirstName("Jan"));
    }

    @Test
    void findUserByFirstNameEqualDataTest()
    {
        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
        assertAll(
            ()-> assertEquals("Jan",us.findUserByFirstName("Jan").get(0).getFirstName()),
            ()-> assertEquals("Kowalski",us.findUserByFirstName("Jan").get(0).getLastName()),
            ()-> assertEquals("j.kowalski@gmail.com",us.findUserByFirstName("Jan").get(0).getEMail())
        );
    }

    @Test
    void findUserByLastNameEqualDataTest()
    {
        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
        assertAll(
                ()-> assertEquals("Jan",us.findUserByLastName("Kowalski").get(0).getFirstName()),
                ()-> assertEquals("Kowalski",us.findUserByLastName("Kowalski").get(0).getLastName()),
                ()-> assertEquals("j.kowalski@gmail.com",us.findUserByLastName("Kowalski").get(0).getEMail())
        );
    }

    @Test
    void findUserByEMailEqualDataTest()
    {
        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
        assertAll(
                ()-> assertEquals("Jan",us.findUserByEMail("j.kowalski@gmail.com").get(0).getFirstName()),
                ()-> assertEquals("Kowalski",us.findUserByEMail("j.kowalski@gmail.com").get(0).getLastName()),
                ()-> assertEquals("j.kowalski@gmail.com",us.findUserByEMail("j.kowalski@gmail.com").get(0).getEMail())
        );
    }

    @Test
    void userIdNotNullTest()
    {
        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
        assertNotNull(us.getAllUsers().get(0).getId());
    }

    @Test
    void userIdChangingTest()
    {
        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
        us.createUser("Janek","Niewiadomski","j.mhm@gmail.com");

        assertNotEquals(us.getAllUsers().get(0).getId(),us.getAllUsers().get(1).getId());
    }

    @Test
    void findUserAndUpdateTest()
    {
        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
        User user = us.findUserByFirstName("Jan").get(0);
        user.setFirstName("Janusz");
        us.updateUser(user);

        assertEquals("Janusz",us.findUserByEMail("j.kowalski@gmail.com").get(0).getFirstName());
    }

    @Test
    void findUserAndDeleteTest()
    {
        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
        User user = us.findUserByFirstName("Jan").get(0);
        us.deleteUser(user);
        assertEquals(0, us.getAllUsers().size());
    }

    @Test
    void emptyUserDataTest()
    {
        assertAll(
                ()-> assertThrows(IllegalArgumentException.class, ()-> us.createUser("","Kowalski","j.kowalski@gmail.com") ),
                ()-> assertThrows(IllegalArgumentException.class, ()-> us.createUser("Jan","","j.kowalski@gmail.com") ),
                ()-> assertThrows(IllegalArgumentException.class, ()-> us.createUser("Jan","Kowalski","") )
        );
    }

}
