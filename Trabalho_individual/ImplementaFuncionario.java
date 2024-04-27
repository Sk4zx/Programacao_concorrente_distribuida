public class ImplementaFuncionario extends Thread implements Funcionario {
    private Conta contaSalario;
    private Conta contaInvestimento;

    public ImplementaFuncionario(Conta contaSalario, Conta contaInvestimento) {
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    @Override
    public void receberSalario(double valor) {
        contaSalario.depositar(valor);
    }

    @Override
    public void investir(double valor) {
        contaInvestimento.depositar(valor);
    }

    @Override
    public double calcularSalario() {
        return 1400.0;
    }


    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

}