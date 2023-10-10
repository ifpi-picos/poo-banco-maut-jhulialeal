import java.util.ArrayList;
import java.util.List;

public class Conta {
    public final int numeroAgencia;
    public final int numeroConta;
    private double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes = new ArrayList<Transacao>();

    public Conta(int numeroAgencia, int numeroConta, double saldo, Cliente cliente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public boolean transferirDinheiro(Conta contaDestino, double valor) {
        System.out.println("Valor a ser transferido R$ " + valor);

        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente");
            return false;
        }

        this.saldo = this.saldo - valor;

        contaDestino.saldo = contaDestino.saldo + valor;

        Transacao transacao = new Transacao("transferencia", valor);
        this.transacoes.add(transacao);

        return true;
    }

    public boolean sacarDinheiro(double valor) {
        System.out.println("Seu saldo e R$ " + this.saldo);

        if (this.saldo < valor) { // 
            System.out.println("Saldo insuficiente");
            return false;
        }

        this.saldo = this.saldo - valor;

        Transacao transacao = new Transacao("saque", valor);
        this.transacoes.add(transacao);

        System.out.println("Apos o saque, seu saldo e R$ " + this.saldo);

        return true;
    }

    public void depositarDinheiro(double valor) {
        this.saldo = this.saldo + valor;

        System.out.println("Seu saldo agora e R$ " + this.saldo);
    }

    public void exibirSaldo() {
        System.out.println("Seu saldo e R$ " + this.saldo);
    }

    public void exibirExtrato() {
        System.out.println("============= EXTRATO ============");
        System.out.println("Ola, " + this.cliente.getNome() + "!");

        for (int i = 0; i < this.transacoes.size(); i++) {
            Transacao transacao = this.transacoes.get(i);

            System.out.println("Voce fez um(a) " + transacao.tipo + " de R$ " + transacao.valor);
        }

        System.out.println("Seu saldo e R$ " + this.saldo);
        System.out.println("===================================");
    }
}
