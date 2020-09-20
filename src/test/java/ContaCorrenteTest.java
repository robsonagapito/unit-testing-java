import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class) @PrepareForTest(ContaCorrente.class)
public class ContaCorrenteTest {
    @Test
    public void testDepositarValorComSaldoZero() throws Exception {
        //arrange
        ContaCorrente contaMock =  new ContaCorrente();
        final String METHOD="getSaldo";

        ContaCorrente spy = PowerMockito.spy(contaMock);
        PowerMockito.when(spy, METHOD)
                .thenReturn( (Double) 1000.00);
        double expect = 1010;
        double actual = 0;
        double valorDep = 10;
        //act
        actual = spy.depositar(valorDep);
        //assert
        Assert.assertEquals(expect, actual, 0);
        PowerMockito.verifyPrivate(spy, Mockito
                .times(1))
                .invoke("getSaldo");

    }

    @Test
    public void depositarValorPositivo(){
        //arrange
        ContaCorrente contaCorrente = new ContaCorrente();
        double valor = 10;
        double esperado = 10;
        double resultado = 0;

        //act
        resultado = contaCorrente.depositar(valor);

        //Assert
        Assert.assertEquals(esperado, resultado, 0);

    }

    @Test
    public void depositarValorNegativo(){
        //arrange
        ContaCorrente contaCorrente = new ContaCorrente();
        double valor = -45;
        double esperado = 0;
        double resultado = 0;

        //act
        resultado = contaCorrente.depositar(valor);

        //Assert
        Assert.assertEquals(esperado, resultado, 0);

    }
    @Test
    public void depositarValorMenor10(){
        //arrange
        ContaCorrente contaCorrente = new ContaCorrente();
        double valor = 11;
        double esperado = 0;
        double resultado = 0;

        //act
        resultado = contaCorrente.depositar(valor);

        //Assert
        Assert.assertEquals(esperado, resultado, 0);

    }

}
