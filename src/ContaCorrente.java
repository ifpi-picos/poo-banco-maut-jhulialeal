public class ContaCorrente extends Conta{
    private double chequeEspecial;
    private int transferenciaSemTaxa;

    public ContaCorrente(int numero, int agencia, double saldo, Notificacao notificacao, Cliente cliente, Endereco endereco) {
        super(numero, agencia, saldo, notificacao, cliente, endereco);

        this.chequeEspecial = saldo*0.30;
        this.transferenciaSemTaxa = 2;
    }

    @Override
    public void transferencia(double valor, Conta destino) {
        if (valor <= (saldo + chequeEspecial)) {
            saldo -= valor;

            if (transferenciaSemTaxa > 0) {
                destino.deposito(valor);
                transferenciaSemTaxa--;
            } else {
                double taxa = valor * 0.10; 
                super.saque(taxa);
                destino.deposito(valor - taxa);
            }
        } else {
            System.out.println("Saldo Insuficiente");
        }
    }
}
