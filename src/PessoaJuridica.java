public class PessoaJuridica extends Cliente{
    private String cnpj;
    private String setor;
    private int quantFuncionarios;
    public PessoaJuridica (String nome, String endereco, String cnpj, String setor, int quantFuncionarios){
        super(nome, endereco);
        this.cnpj = cnpj;
        this.setor = setor;
        this.quantFuncionarios = quantFuncionarios;

    }
    public String toString(){
        String dadosPJ = "Nome: "+ getNome()+
                "CNPJ: "+ cnpj+
                "Endereço: "+ getEndereco()+
                "Setor: "+ setor+
                "Quantidade de Funcionários: "+ quantFuncionarios;
        return dadosPJ;
    }

    public boolean equals(Object object){
        if(object instanceof PessoaJuridica){
            PessoaJuridica pj = (PessoaJuridica) object;
            if(this.cnpj.equals(pj.cnpj)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean autenticar(String Chave){
        return Chave.equals(this.cnpj);
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public void setSetor(String setor){
        this.setor = setor;
    }

    public void setQuantFuncionarios(int quantFuncionarios){
        this.quantFuncionarios = quantFuncionarios;
    }

    //getters
    public String getCnpj(){
        return cnpj;
    }

    public String getSetor(){
        return setor;
    }

    public int getQuantFuncionarios(){
        return quantFuncionarios;
    }
}

