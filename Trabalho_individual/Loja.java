import java.util.List;

public class Loja {
    private Conta contaLoja;
    private List<Funcionario> funcionarios;
    private Banco banco;
    public boolean deveContinuar = true;

    public Loja(Conta contaLoja, List<Funcionario> funcionarios, Banco banco) {
        this.contaLoja = contaLoja;
        this.funcionarios = funcionarios;
        this.banco = banco;
        new Thread(this::verificarESalarioDoFuncionario).start();
    }

    public Conta getConta() {
        return contaLoja;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    private int ultimoFuncionarioPagoIndex = -1;

    public void pagarFuncionario() {
        double salarioFuncionario = 1400.0;

        if (ultimoFuncionarioPagoIndex == funcionarios.size() - 1) {
            ultimoFuncionarioPagoIndex = -1;
        }

        // Passa para o proximo funcionario que não ecebeu salario
        for (int i = ultimoFuncionarioPagoIndex + 1; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            if (contaLoja.getSaldo() >= salarioFuncionario) {
                banco.transferencia(contaLoja, funcionario.getContaSalario(), salarioFuncionario);
                System.out.println(
                        "Salário pago para " + funcionario.getContaSalario().getId() +
                                " da loja " + contaLoja.getId());

                double valorTransferencia = salarioFuncionario * 0.20;
                banco.transferencia(funcionario.getContaSalario(), funcionario.getContaInvestimento(),
                        valorTransferencia);
                System.out.println(
                        "Transferência de R$ " + valorTransferencia
                                + " realizada da conta salário para investimento para " +
                                funcionario.getContaSalario().getId());

                ultimoFuncionarioPagoIndex = i;
                break;
            }
        }
    }

    private void verificarESalarioDoFuncionario() {

        long intervaloVerificacao = 250; // intervalo de verificação(ms)

        while (deveContinuar) {
            try {
                Thread.sleep(intervaloVerificacao);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (contaLoja.getSaldo() >= 1400.0) {
                pagarFuncionario();
            }
        }
    }
}