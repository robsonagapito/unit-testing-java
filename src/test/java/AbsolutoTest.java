import org.junit.Assert;
import org.junit.Test;

public class AbsolutoTest {

    @Test
    public void testValorNegativo(){
        //arrange
        Absoluto absoluto = new Absoluto();
        int actual;
        int expect = 2;

        //act
        actual = absoluto.retornaValorAbsoluto(-2);

        //assert
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void testValorPositivo(){
        //arrange
        Absoluto absoluto = new Absoluto();
        int actual;
        int expect = 2;

        //act
        actual = absoluto.retornaValorAbsoluto(2);

        //assert
        Assert.assertEquals(expect,actual);
    }

}
