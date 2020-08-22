public class ContaMock {
    private double saldo;

    public ContaMock(){
        zeraSaldo();
    }

    private void zeraSaldo(){
        saldo = 0;
    }

    public double depositarValor(double valor){
        if (valor > 0 ) {
            if (valor <= 10) {
                setSaldo(getSaldo() + valor);
            } else {
                System.out.println("Valor não pode ser maior que 10 reais");
            }
        }
        return getTotal();
    }

    public double sacarValor(double valor){
        if (valor > 0 ) {
            setSaldo(getSaldo() - valor);
        }
        return getSaldo();
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private double getSaldo(){
        return saldo;
    }

    public double getTotal(){
        return saldo;
    }

}
