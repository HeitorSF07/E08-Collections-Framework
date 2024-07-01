public class ContaCorrente extends Conta implements ITaxas{
    public ContaCorrente(int numero, Cliente dono, double saldo, double limite) {
        super(numero, dono, saldo, limite);
    }
    public boolean setLimite(double limite){
        if (limite < -100) {
            this.limite = 0;
            System.out.println("Limite inválido para conta corrente");
            return false;
        } else {
            this.limite = limite;
            return true;
        }
    }

    public double calculaTaxas() {
        if(getDono() instanceof PessoaFisica) {
            return 10;
        } else {
            return 20;
        }
    }
}



