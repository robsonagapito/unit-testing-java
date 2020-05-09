public class Fatorial {

    public int resultadoFatorial(int num){
        int fatorial = 0;
        int n = num;

        if (n < 0) {
            System.out.println("Número Inválido");
            n = -1;
        } else {
            fatorial = 1;
            for (int i = 1; i <= n; i++){
                fatorial *= i;
                System.out.println(fatorial);
            }
        }
        return fatorial;
    }

}