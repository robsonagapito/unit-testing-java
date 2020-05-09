public class Absoluto {
    public int retornaValorAbsoluto(int valor){
        int res = valor;
        if (valor < 0) {
            res = -valor;
        }
        System.out.println(res);
        return res;
    }
}