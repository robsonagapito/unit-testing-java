import org.junit.Assert;
import org.junit.Test;

public class ContaCorrenteTest {

    @Test
    public void depositarValorPositivo(){
        //arrange
        ContaCorrente contaCorrente = new ContaCorrente();
        double valor = 10;
        double esperado = 1;
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
