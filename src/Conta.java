import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private final int numero;
    private final int agencia;
    protected double saldo;
    protected Notificacao notificacao;
    private Cliente cliente;
    private List<Transacao> extrato;

    public Conta(int numero, int agencia, Notificacao notificacao, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = 0.0;
        this.notificacao = notificacao;
        this.cliente = cliente;
        this.extrato = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void saque(double valor);

    public abstract void deposito(double valor);

    public abstract void transferencia(double valor, Conta destino);

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Transacao> getExtrato() {
        return extrato;
    }

    public void exibirExtrato() {
        for (Transacao extratos : extrato) {
            System.out.println("\n********************");
            System.out.println("Tipo: " + extratos.getTipo());
            System.out.println("Valor: " + extratos.getValor());
            System.out.println("Data: " + extratos.getData());
            System.out.println("********************");
        }
    }
}
