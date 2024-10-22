class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

class MontoInvalidoException extends Exception {
    public MontoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto para depositar debe ser mayor a cero.");
        }
        saldo += monto;
        System.out.println("Depósito exitoso. Saldo actual: " + saldo);
    }

    public void retirar(double monto) throws SaldoInsuficienteException, MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto para retirar debe ser mayor a cero.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la operación.");
        }
        saldo -= monto;
        System.out.println("Retiro exitoso. Saldo actual: " + saldo);
    }

    public void transferir(CuentaBancaria destino, double monto) throws SaldoInsuficienteException, MontoInvalidoException {
        retirar(monto);
        destino.depositar(monto);
        System.out.println("Transferencia exitosa. Saldo actual: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}