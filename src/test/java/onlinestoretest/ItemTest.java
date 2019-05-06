package onlinestoretest;

import onlinestore.entity.Item;
import onlinestore.repository.IDataStore;
import onlinestore.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest
{
    private ItemService is;

    @BeforeEach
    void setUp()
    {
        IDataStore<Item> ds = new MockDataStore<>();
        is = new ItemService();
        is.setDataStore(ds);
    }

    @Test
    void createItemTest()
    {
        is.createItem("mleko", 2.50);
        assertEquals(1, is.getAllItems().size());
    }

    @Test
    void findItemByNameNotNullTest()
    {
        is.createItem("mleko", 2.50);
        assertNotNull(is.findItemByName("mleko"));
    }

    @Test
    void findItemByNameEqualDataTest()
    {
        is.createItem("mleko", 2.50);
        assertAll(
                ()-> assertEquals("mleko",is.findItemByName("mleko").get(0).getName()),
                ()-> assertEquals(2.50,is.findItemByName("mleko").get(0).getPrice(),0.0001)
        );
    }

    @Test
    void findItemByPriceEqualDataTest()
    {
        is.createItem("mleko", 2.50);
        assertAll(
                ()-> assertEquals("mleko",is.findItemByPrice(2.50).get(0).getName()),
                ()-> assertEquals(2.50,is.findItemByPrice(2.50).get(0).getPrice(),0.0001)
        );
    }

    @Test
    void itemIdNotNullTest()
    {
        is.createItem("mleko", 2.50);
        assertNotNull(is.getAllItems().get(0).getId());
    }

    @Test
    void itemIdChangingTest()
    {
        is.createItem("mleko", 2.50);
        is.createItem("masło", 5.00);

        assertNotEquals(is.getAllItems().get(0).getId(),is.getAllItems().get(1).getId());
    }

    @Test
    void findItemAndUpdateTest()
    {
        is.createItem("mleko", 2.50);
        Item item = is.findItemByName("mleko").get(0);
        item.setName("super mleko");
        is.updateItem(item);

        assertEquals("super mleko",is.findItemByPrice(2.50).get(0).getName());
    }
}
