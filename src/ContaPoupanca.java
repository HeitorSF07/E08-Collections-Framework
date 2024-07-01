public class ContaPoupanca extends Conta implements ITaxas{

    public ContaPoupanca(int numero, Cliente dono, double saldo, double limite) {
        super(numero, dono, saldo, limite);
    }
    public boolean setLimite(double limite){
        if (limite < 100 || limite >1000) {
            this.limite = 0;
            System.out.println("Limite inválido para conta poupança");
            return false;
        } else {
            this.limite = limite;
            return true;
        }
    }

    @Override
    public double calculaTaxas() {
        return 0;
    }
}


