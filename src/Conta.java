public abstract class Conta {
    private final int numero;
    private final int agencia;
    protected double saldo;
    protected Notificacao notificacao;
    private Cliente cliente;
    private Endereco endereco;

    public Conta(int numero, int agencia, double saldo, Notificacao notificacao, Cliente cliente, Endereco endereco) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.notificacao = notificacao;
        this.cliente = cliente;
        this.endereco = endereco;
    }


public double getSaldo() {
    return saldo;
}

    public void saque(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            this.notificacao.enviaNotificacao("saque", valor);
        } else {
            System.out.println("Saldo insuficiente para o saque de R$" + valor);
        }
    }

    public boolean deposito(double valor) {
        if (valor > 0) {
            saldo += valor;
            this.notificacao.enviaNotificacao("depósito", valor);
            return true; 
        } else {
            System.out.println("Valor inválido para depósito");
            return false;
        }
    }

    public void transferencia(double valor, Conta destino) {
        if (valor > 0 && saldo >= valor && destino != null) {
            this.saldo -= valor;
            boolean depositoBemSucedido = destino.deposito(valor); 
            if (depositoBemSucedido) {
                this.notificacao.enviaNotificacao("transferência", valor);
                destino.notificacao.enviaNotificacao("recebimento de transferência", valor);
                System.out.println("Transferência bem-sucedida.");
            } else {
                System.out.println("Falha ao transferir dinheiro para a conta de destino.");
            }
        } else {
            System.out.println("Transferência não permitida. Verifique o saldo da conta de origem e a conta de destino.");
        }
    }
}
