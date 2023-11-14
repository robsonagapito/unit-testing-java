import org.junit.Assert;
import org.junit.Test;

public class BookTest {

    @Test
    public void testGetTitle(){
        //arrange
        Book book = new Book();
        String exp = "TODAY IS THE DAY";

        //act
        String act = book.getTitle();

        //assert
        Assert.assertEquals(exp, act);
    }

}
