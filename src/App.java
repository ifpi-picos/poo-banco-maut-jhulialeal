import java.util.Date;

class App {
    public static void main(String[] args) {
        Notificacao notificacao1 = new NotificacaoSms();
        Notificacao notificacao2 = new NotificacaoEmail();
        Endereco endereco = new Endereco("Rua 21 de abril", 5665, "Pantanal", "Picos", "PI");
        Cliente cliente = new Cliente("000.000.000-00", "Fulano de Tal", new Date());
        ContaCorrente contaCorrente =
                new ContaCorrente(123, 456, 0, notificacao1, cliente, endereco);
        ContaPoupanca contaPoupanca =
                new ContaPoupanca(123, 456, 0, notificacao2, cliente, endereco);


        contaCorrente.deposito(1000);
        contaCorrente.saque(500);
        contaCorrente.transferencia(100, contaPoupanca);
        contaCorrente.transferencia(100, contaPoupanca);
        contaCorrente.transferencia(100, contaPoupanca);
        System.out.println("saldo conta corrente: " + contaCorrente.getSaldo());
        contaCorrente.transferencia(100, contaPoupanca);
        System.out.println("saldo conta corrente: " + contaCorrente.getSaldo());
        contaCorrente.transferencia(100, contaPoupanca);
        System.out.println("saldo conta corrente: " + contaCorrente.getSaldo());
        contaCorrente.transferencia(10, contaPoupanca);
        System.out.println("Saldo da conta poupança: " + contaPoupanca.getSaldo());
        System.out.println("saldo conta corrente: " + contaCorrente.getSaldo());

        contaCorrente.exibirExtrato();

        contaPoupanca.deposito(1000);
        contaPoupanca.saque(1000);
        // contaPoupanca.transferencia(100, contaCorrente);
        System.out.println("Saldo da conta poupança: " + contaPoupanca.getSaldo());
        System.out.println("Saldo conta corrente: " + contaCorrente.getSaldo());

        contaPoupanca.exibirExtrato();

        // tudo certo, parabéns!
    }
}
