public class Conta {
    private String id;
    private double saldo;

    public Conta(String id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public synchronized void depositar(double valor) {
        saldo += valor;
    }

    public synchronized void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        }
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public String getId() {
        return id;
    }
}
