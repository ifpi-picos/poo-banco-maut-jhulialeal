import java.util.Date;

public class Transacao {
    private String tipo;
    private double valor;
    private Date data;
    
    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = new Date();
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }
    
}
