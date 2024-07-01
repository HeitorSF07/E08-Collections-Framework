public class OperacaoSaque extends Operacao implements ITaxas{
    public OperacaoSaque (double valor){
        super ('s', valor);
    }
    public String toString(){
        String op = getTipo() + "\t" + getValor()+ "\t" + getData();
        return op;
    }
    public double calculaTaxas() {
        return 0.05;
    }
}