public class PessoaFisica extends Cliente{
    private String cpf;
    private int idade;
    private char sexo;
    public PessoaFisica (String nome, String endereco, String cpf, int idade, char sexo){
        super(nome, endereco);
        this.sexo = sexo;
        this.idade = idade;
        this.cpf = cpf;

    }
    public String toString(){
        String dadosPF ="Nome: "+ getNome()+
                "\tCPF: " + cpf+
                "\tEndereço: "+ getEndereco()+
                "\tIdade: "+ idade+
                "\tSexo: "+ sexo;
        return dadosPF;
    }

    public boolean equals(Object object){
        if(object instanceof PessoaFisica){
            PessoaFisica pf = (PessoaFisica) object;
            if(this.cpf.equals(pf.cpf)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean autenticar(String Chave){
        return Chave.equals(this.cpf);
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setSexo(char sexo){
        this.sexo = sexo;
    }

    //getters
    public String getCpf(){
        return cpf;
    }

    public int getIdade(){
        return idade;
    }

    public char getSexo(){
        return sexo;
    }
}
