public class Main {
    public static void main(String[] args) {

        PessoaFisica F1 = new PessoaFisica("João", "Av. Antônio Carlos", "112.345.708-22", 35, 'm');
        Conta contaF1 = new ContaCorrente(1234, F1, 5000, 2000);


        contaF1.depositar(2000);
        contaF1.depositar(2000);
        contaF1.sacar(500);
        contaF1.sacar(1000);

        contaF1.imprimirExtrato();
        System.out.println(F1.toString());
        System.out.println(contaF1.toString());
        System.out.println(F1.autenticar("1234"));
        contaF1.imprimirExtratoTaxas();

    }
}