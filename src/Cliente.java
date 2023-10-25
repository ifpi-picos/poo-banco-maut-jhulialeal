import java.util.Date;

public class Cliente {
    private String cpf;
    private String nome;
    private Date dataNascimento; 
    private Endereco endereco;


    public Cliente(String cpf, String nome, Date dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    
    public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
}

}
