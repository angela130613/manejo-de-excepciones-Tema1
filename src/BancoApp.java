public class BancoApp {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Alice", 500);
        CuentaBancaria cuenta2 = new CuentaBancaria("Bob", 300);

        try {
            cuenta1.depositar(200);
            cuenta1.retirar(100);
            cuenta1.transferir(cuenta2, 150);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (MontoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Operación finalizada.");
        }

        System.out.println("Saldo final de Alice: " + cuenta1.getSaldo());
        System.out.println("Saldo final de Bob: " + cuenta2.getSaldo());
    }
}
