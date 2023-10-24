public class ContaPoupanca extends Conta {
    private double rendimento;

    public ContaPoupanca(int numero, int agencia, double saldo, Notificacao notificacao, Cliente cliente, Endereco endereco) {
        super(numero, agencia, saldo, notificacao, cliente, endereco);

        this.rendimento = 0.10;
    }

    @Override
    public void saque (double valor) {
        double taxa = 0.05; 
        double valorComTaxa = valor * (1 - taxa);
        if (valorComTaxa <= saldo) {
            saldo -= valorComTaxa;
            notificacao.enviaNotificacao("saque", valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para o saque de R$" + valor);
        }
    }

    @Override
    public void transferencia(double valor, Conta destino) {
        double taxa = 0.10; 
        double valorComTaxa = valor * (1 - taxa);
        if (valorComTaxa <= saldo) {
            saldo -= valorComTaxa;
            destino.deposito(valorComTaxa);
            this.notificacao.enviaNotificacao("transferência", valor);
            destino.notificacao.enviaNotificacao("recebimento de transferência", valorComTaxa);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para a transferência de R$" + valor);
        }
    }

    @Override
    public boolean deposito(double valor) {
        double rendimentoValor = valor * rendimento;
        double valorComRendimento = valor + rendimentoValor;
        return super.deposito(valorComRendimento);
    }
}
