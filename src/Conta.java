public class Conta {
    public final int numeroAgencia;
    public final int numeroConta;
    private double saldo;
    private Cliente cliente;
    private int transferencias;
    private int saques;

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

        this.transferencias = this.transferencias + 1;

        return true;
    }

    public boolean sacarDinheiro(double valor) {
        System.out.println("Seu saldo e R$ " + this.saldo);

        if (this.saldo < valor) { // 
            System.out.println("Saldo insuficiente");
            return false;
        }

        this.saldo = this.saldo - valor;
        this.saques = this.saques + 1;

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
        System.out.println("Ola, " + this.cliente.getNome() + "!");
        System.out.println("Voce fez " + this.saques + " saques e " + this.transferencias + " tranferencias");
        System.out.println("Seu saldo e R$ " + this.saldo);
    }
}
