import java.util.Date;

class App {
    public static void main(String[] args) {
        // Cliente 1
        Notificacao notificacao = new NotificacaoSms();
        Endereco endereco = new Endereco("Rua 21 de abril", 5665, "Pantanal", "Picos", "PI");
        Cliente cliente = new Cliente("000.000.000-00", "Fulano de Tal", new Date());
        ContaCorrente contaCorrente = new ContaCorrente(123, 456, 1000, notificacao, cliente, endereco);

        // Segunda conta
        ContaPoupanca contaPoupanca = new ContaPoupanca(123, 456, 50, notificacao, cliente, endereco);

        contaCorrente.transferencia(20, contaPoupanca);
    }
}