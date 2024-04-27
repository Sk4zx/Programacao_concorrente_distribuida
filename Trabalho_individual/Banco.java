import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private Lock lock;
    private CountDownLatch transferenciasConcluidas;

    public Banco(Lock lock2) {
        this.lock = new ReentrantLock();
        this.transferenciasConcluidas = new CountDownLatch(5); // esperar 5 compras dos clientes no minimo
    }

    public void transferencia(Conta origem, Conta destino, double valor) {
        lock.lock();
        try {
            if (origem.getSaldo() >= valor) {
                origem.sacar(valor);
                destino.depositar(valor);
                System.out.println(
                        "Transferência de " + origem.getId() + " para " + destino.getId() + " valor: " + valor);
            } else {
                System.out.println(
                        "Saldo insuficiente para transferir de " + origem.getId() + " para " + destino.getId());
            }
        } finally {
            lock.unlock();
        }

        transferenciasConcluidas.countDown();
    }

    public void esperarTransferenciasConcluidas() throws InterruptedException {
        transferenciasConcluidas.await();
    }

    public void efetuarPagamento(Funcionario funcionario, double valorSalario, double valorInvestimento) {
        lock.lock();
        try {
            funcionario.receberSalario(valorSalario);
            funcionario.investir(valorInvestimento);
        } finally {
            lock.unlock();
        }
    }
}
