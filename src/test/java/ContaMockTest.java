import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ContaMock.class)
public class ContaMockTest {

    private double valorDep;
    private double valorMaior;
    private double valorNeg;
    private double valorSac;

    @Before
    public void prepareTests(){
        valorDep = 10;
        valorMaior = 12;
        valorNeg = -10.00;
        valorSac = 7.00;
    }

    @Test
    public void testDepositarValorComSaldoZero() throws Exception {

        //arrange
        ContaMock contaMock =  new ContaMock();
        final String METHOD="getSaldo";

        ContaMock spy = PowerMockito.spy(contaMock);
        PowerMockito.when(spy, METHOD)
                    .thenReturn( (Double) 1000.00);

        double expect = 1010;
        double actual = 0;

        //act
        actual = spy.depositarValor(valorDep);

        //assert
        Assert.assertEquals(expect, actual, 0);
        PowerMockito.verifyPrivate(spy, Mockito
                .times(1))
                .invoke("getSaldo");

    }

    @Test
    public void testSacarValorComSaldoMaiorQueZero() throws Exception {

        //arrange
        ContaMock conta =  new ContaMock();

        double expect = 3.00;
        double actual;

        //act
        conta.depositarValor(valorDep);
        conta.sacarValor(valorSac);

        actual = conta.getTotal();

        //assert
        Assert.assertEquals(  expect, actual, 0);

    }

    @Test
    public void testDepositoValorMaiorQue10() throws Exception {

        //arrange
        ContaMock conta =  new ContaMock();
        double valorDep2 = 12.00;
        double expect = 3.00;
        double actual;

        //act
        conta.depositarValor(valorDep);
        conta.depositarValor(valorDep2);
        conta.sacarValor(valorSac);

        actual = conta.getTotal();

        //assert
        Assert.assertEquals(  expect, actual, 0);

    }

    @Test
    public void testDepositarValorComValorNegativo() throws Exception {

        //arrange
        ContaMock conta =  new ContaMock();
        double expect = 10.00;
        double actual;

        //act
        conta.depositarValor(valorDep);
        conta.depositarValor(valorNeg);

        actual = conta.getTotal();

        //assert
        Assert.assertEquals(  expect, actual, 0);

    }

    @Test
    public void testSacarValorComValorNegativo() throws Exception {

        //arrange
        ContaMock conta =  new ContaMock();
        double expect = 10.00;
        double actual;

        //act
        conta.depositarValor(valorDep);
        conta.sacarValor(valorNeg);

        actual = conta.getTotal();

        //assert
        Assert.assertEquals(  expect, actual, 0);

    }

}
