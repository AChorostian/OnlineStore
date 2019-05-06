import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

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
    void UserIdNotNullTest()
    {
        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
        assertNotNull(us.getAllUsers().get(0).getId());
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


//    @Test
//    void deleteUserTest()
//    {
//        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
//        assertTrue(us.getAllUsers().size() == 1);
//    }
//
//    @Test
//    void addTwoUsersTest()
//    {
//        us.createUser("Jan","Kowalski","j.kowalski@gmail.com");
//        us.createUser("Janek","Tomaszewski","j.kowalski@gmail.com");
//        assertTrue(us.getAllUsers().size() == 2);
//    }
}
