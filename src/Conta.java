
import java.util.ArrayList;
import java.util.Collections;

public abstract class Conta implements ITaxas{

    private int numero;

    private Cliente dono;

    private double saldo;

    protected double limite;

    private ArrayList<Operacao> operacoes;

    private int proximaOperacao;

    private static int totalContas = 0;

    public static int cont=0;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.operacoes = new ArrayList<Operacao>();
        this.proximaOperacao = 0;

        Conta.totalContas++;
    }


    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor;
            this.operacoes.add (new OperacaoSaque(valor));
            cont++;
            return true;
        }

        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        this.operacoes.add(new OperacaoDeposito(valor));
        cont++;
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public String toString() {
        String dados= "===== Conta: " + this.numero + " ====="+"\nDono: " + this.dono.getNome()+ "\nSaldo: " + this.saldo +
                "\nLimite: " + this.limite+ "\n====================";
        return dados;
    }

    public void imprimirExtrato(int flag) {
     if(flag == 1) {
         System.out.println("======= Extrato Conta: " + this.numero + " ======");
         for (Operacao atual : this.operacoes) {
             if (atual != null) {
                 System.out.println(atual.toString());
             }
         }
         System.out.println("====================");
     }else if(flag == 2){
         Collections.sort(operacoes);
         System.out.println("======= Extrato Conta : " + this.numero + " (Ordenado) ======");
         for (Operacao atual : this.operacoes) {
             if (atual != null) {
                 System.out.println(atual.toString());
             }
         }
         System.out.println("====================");
     }else{
         System.out.println("Forma de ordenação inválida");
     }
    }

    public boolean equals(Object object){
        if(object instanceof Conta){
            Conta Cnt= (Conta) object;
            if(this.numero == Cnt.numero){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void imprimirExtratoTaxas(){
        double total = 0;

        System.out.printf("====== Extrato de Taxas ======\n" +
                "Manutenção da conta: %.2f \n\n" +
                "Operações\n", calculaTaxas());
        total += calculaTaxas();
        for(Operacao atual : this.operacoes) {
            if (atual != null) {
                if(atual instanceof OperacaoSaque) {
                    System.out.printf("Saque: %.2f\n", atual.calculaTaxas());
                    total += atual.calculaTaxas();
                }
            }
        }
        System.out.printf("\nTotal: %.2f \n", total);
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public abstract boolean setLimite(double limite);
}

