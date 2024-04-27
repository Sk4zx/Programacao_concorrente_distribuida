public class Cliente extends Thread {
    private Conta conta;
    private Banco banco;
    private Loja loja1;
    private Loja loja2;

    public Cliente(Conta conta, Banco banco, Loja loja1, Loja loja2) {
        this.conta = conta;
        this.banco = banco;
        this.loja1 = loja1;
        this.loja2 = loja2;
    }

    @Override
    public void run() {
        while (conta.getSaldo() > 0) {
            int valorCompra = (conta.getSaldo() >= 200) ? ((Math.random() < 0.5) ? 100 : 200) : 100;
            if (valorCompra <= conta.getSaldo()) {
                Loja loja = (Math.random() < 0.5) ? loja1 : loja2;
                banco.transferencia(conta, loja.getConta(), valorCompra);
                esperar();
            } else {
                break;
            }
        }
        System.out.println(conta.getId() + " ficou sem saldo");
    }

    private void esperar() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
