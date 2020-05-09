import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BigBrotherTest {

    BigBrother bigBrother;
    String[] nome;

    @Before
    public void prepareTest(){
        bigBrother = new BigBrother();
        nome = new String[]{"Robson", "Agapito"};
    }

    @Test
    public void testAdicionaBrother(){
        //Arrange
        long count = 2;

        //Act
        bigBrother.adicionaBrother(nome[0]);
        bigBrother.adicionaBrother(nome[1]);

        //Assert
        Assert.assertTrue(bigBrother.getParedao().containsKey(nome[0]));
        Assert.assertTrue(bigBrother.getParedao().containsKey(nome[1]));
        Assert.assertEquals(count, bigBrother.getParedao().size());

    }

    @Test
    public void testVotarBrother(){
        //Arrange
        long count = 2;

        //Act
        bigBrother.adicionaBrother(nome[0]);
        bigBrother.adicionaBrother(nome[1]);

        bigBrother.votarBrother(nome[0]);
        bigBrother.votarBrother(nome[0]);
        bigBrother.votarBrother(nome[1]);

        //Assert
        Assert.assertEquals((long) bigBrother.getParedao().get(nome[0]),2 );
        Assert.assertEquals((long) bigBrother.getParedao().get(nome[1]),1 );
        Assert.assertEquals(count, bigBrother.getParedao().size());

    }

    @Test
    public void testUmBrotherEliminado(){
        //Arrange
        long count = 2;
        String actual = "";
        String expect = "Brother eliminado => " + nome[0];

        //Act
        bigBrother.adicionaBrother(nome[0]);
        bigBrother.adicionaBrother(nome[1]);

        bigBrother.votarBrother(nome[0]);
        bigBrother.votarBrother(nome[0]);
        bigBrother.votarBrother(nome[1]);

        actual = bigBrother.brotherEliminado();

        //Assert
        Assert.assertEquals(expect, actual );
    }

    @Test
    public void testEliminacaoSemBrotherCadastrado(){
        //Arrange
        long count = 2;
        String actual = "";
        String expect = "Nenhum brother cadastrado";

        //Act
        actual = bigBrother.brotherEliminado();

        //Assert
        Assert.assertEquals(expect, actual );
    }

    @Test
    public void testEmpateNaEliminacao(){
        //Arrange
        long count = 2;
        String actual = "";
        String expect = "Brothers empatados, reabra a votação!";

        //Act
        bigBrother.adicionaBrother(nome[0]);
        bigBrother.adicionaBrother(nome[1]);

        bigBrother.votarBrother(nome[0]);
        bigBrother.votarBrother(nome[1]);

        actual = bigBrother.brotherEliminado();

        //Assert
        Assert.assertEquals(expect, actual );
    }

    @Test
    public void testNenhumVotoParaEliminacao(){
        //Arrange
        long count = 2;
        String actual = "";
        String expect = "Brothers sem votos ainda!";

        //Act
        bigBrother.adicionaBrother(nome[0]);
        bigBrother.adicionaBrother(nome[1]);

        actual = bigBrother.brotherEliminado();

        //Assert
        Assert.assertEquals(expect, actual );
    }

    @Test
    public void testListaBrotherComDoisBrother(){
        //Arrange
        Integer actual = 0;
        Integer expect = 2;

        //Act
        bigBrother.adicionaBrother(nome[0]);
        bigBrother.adicionaBrother(nome[1]);

        actual = bigBrother.listaParedao().size();

        //Assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testListaBrotherComUmBrother(){
        //Arrange
        Integer actual = 0;
        Integer expect = 0;

        //Act
        bigBrother.adicionaBrother(nome[0]);

        actual = bigBrother.listaParedao().size();

        //Assert
        Assert.assertEquals(expect, actual);
    }


}
