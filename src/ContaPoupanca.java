public class ContaPoupanca extends Conta {
    private double rendimento;

    public ContaPoupanca(int numero, int agencia, double saldo, Notificacao notificacao, Cliente cliente, Endereco endereco) {
        super(numero, agencia, notificacao, cliente);

        this.rendimento = 0.1;
    }

    @Override
    public void saque (double valor) {
        if (valor <= saldo) {
            double taxa = 0.05;
            double valorComTaxa = valor + (valor * taxa);
            saldo-=valorComTaxa;
            notificacao.enviaNotificacao("saque", valorComTaxa);
            getExtrato().add(new Transacao("saque", valorComTaxa));
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
            getExtrato().add(new Transacao("saque", valorComTaxa));
            System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para a transferência de R$" + valor);
        }
    }

    @Override
    public void deposito(double valor) {
        double rendimentoValor = valor+(valor * rendimento);
        saldo+= rendimentoValor;
        notificacao.enviaNotificacao("deposito", rendimentoValor);
        getExtrato().add(new Transacao("deposito", rendimentoValor));

    }
}
