public  class OperacaoDeposito extends Operacao implements ITaxas{
    public OperacaoDeposito(double valor){
        super('d', valor);
    }

    public String toString() {
        String op = getTipo() + "\t" + getValor() + "\t" + getData();
        return op;
    }

    public double calculaTaxas() {
        return 0;
    }
}

