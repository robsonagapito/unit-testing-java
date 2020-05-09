import org.junit.Assert;
import org.junit.Test;

public class FatorialTest{

    @Test
    public void testValorMaiorQueDois(){
        //arrange
        Fatorial fatorial = new Fatorial();
        int expect = 6;
        int actual;

        //act
        actual = fatorial.resultadoFatorial(3);

        //assert
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void testValorZero(){
        //arrange
        Fatorial fatorial = new Fatorial();
        int expect = 0;
        int actual;

        //act
        actual = fatorial.resultadoFatorial(-2);

        //assert
        Assert.assertEquals(expect ,actual);
    }

}