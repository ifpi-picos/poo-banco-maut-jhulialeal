import java.util.Date;

public class Cliente {
    private String cpf;
    private String nome;
    private Date dataNascimento; 


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

}
