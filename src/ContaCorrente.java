public class ContaCorrente extends Conta{
    private double chequeEspecial;
    private int transferenciaSemTaxa;

    public ContaCorrente(int numero, int agencia, double saldo, Notificacao notificacao, Cliente cliente, Endereco endereco) {
        super(numero, agencia, notificacao, cliente);

        this.chequeEspecial = 100;
        this.transferenciaSemTaxa = 2;
    }

    @Override
    public void transferencia(double valor, Conta destino) {
        if (valor <= (super.saldo + this.chequeEspecial)) {
            if (this.transferenciaSemTaxa > 0) {
                saldo -= valor;
                destino.saldo += valor;
                this.transferenciaSemTaxa--;
                getExtrato().add(new Transacao("transferencia", valor));
                notificacao.enviaNotificacao("transferencia", valor);
            } else {
                saldo -= (valor + (valor *0.1));
                destino.saldo += valor;
                getExtrato().add(new Transacao("transferencia", valor));
                notificacao.enviaNotificacao("transferencia", valor);
            }
        } else {
            System.out.println("Saldo Insuficiente");
        }
    }

    @Override
    public void saque(double valor) {
        if (valor <= saldo+ chequeEspecial) {
            this.saldo -= valor + (valor * 0.05);
            this.notificacao.enviaNotificacao("saque", valor);
            getExtrato().add(new Transacao("saque", valor));
        } else {
            System.out.println("Saldo insuficiente para o saque de R$" + valor);
        }
    }

    @Override
    public void deposito(double valor) {
        if(valor>0){
            saldo+=valor;
            notificacao.enviaNotificacao("deposito", valor);
            getExtrato().add(new Transacao("deposito", valor));
        }else{
            System.out.println("Nao foi possivel realizar deposito");
        }
        
    }
    
}
