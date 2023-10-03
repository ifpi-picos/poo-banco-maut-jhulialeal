public class App {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("jhulia", "000.000.000-00", "27/03/2005", "pantanal");

        Conta conta1 = new Conta(1234, 5555, 1000, cliente1);
        Conta conta2 = new Conta(1234, 7777, 1000, cliente1);

        conta1.transferirDinheiro(conta2, 250);
        conta1.exibirSaldo();

        conta1.sacarDinheiro(100);
        conta1.exibirSaldo();

        conta1.depositarDinheiro(100);
        conta1.exibirSaldo();

        conta1.exibirExtrato();
    }
}