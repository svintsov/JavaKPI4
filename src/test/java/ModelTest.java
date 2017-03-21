import com.bazyl.education.Model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {

    Item item1;
    Item item2;
    Item item3;

    @Before
    public void init(){
        item1 = new Item("car","2","apple");
        item2 = new Item(item1);
        item3 = item1.clone();
    }

    @Test
    public void equalInit(){
        Assert.assertEquals(item1,item2);
    }

    @Test
    public void cloneInit(){
        Assert.assertEquals(item1,item3);
    }

    @Test
    public void notEqualAfterChange(){
        item2.setPrice("3");
        Assert.assertNotEquals(item1,item2);
    }

    @Test
    public void wrongArgumentModel(){
        Item item = new Item("green car","32","apple");
    }

}
