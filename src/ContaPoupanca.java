public class ContaPoupanca extends Conta {
    private double rendimento;

    public ContaPoupanca(int numero, int agencia, double saldo, Notificacao notificacao, Cliente cliente, Endereco endereco) {
        super(numero, agencia, saldo, notificacao, cliente, endereco);

        this.rendimento = 0.10;
    }

    @Override
    public void saque (double valor) {
        if (valor <= saldo) {
            double taxa = 0.05;

            double valorComTaxa = valor + (valor * taxa);

            super.saque(valorComTaxa);
        } else {
            System.out.println("Saldo insuficiente para o saque de R$" + valor);
        }
    }

    @Override
    public void transferencia(double valor, Conta destino) {
        double taxa = 0.10; 
        double valorComTaxa = valor * (taxa);
        if (valorComTaxa <= saldo) {
            saldo -= valorComTaxa;
            destino.deposito(valor);
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
