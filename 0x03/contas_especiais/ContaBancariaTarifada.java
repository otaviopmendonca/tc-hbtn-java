import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {

    private int quantidadeTransacoes;
    private static final double TARIFA_TRANSACAO = 0.10;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        if (getSaldo() < (valor + TARIFA_TRANSACAO)) {
            throw new OperacaoInvalidaException("Saldo insuficiente para saque e tarifa de transação.");
        }
        super.sacar(valor);
        try {
            super.sacar(TARIFA_TRANSACAO);
        } catch (OperacaoInvalidaException e) {
            throw new OperacaoInvalidaException("Erro ao aplicar tarifa de saque: " + e.getMessage());
        }
        quantidadeTransacoes++;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);

        try {
            setSaldo(getSaldo() - TARIFA_TRANSACAO);
        } catch (Exception e) {
            throw new OperacaoInvalidaException("Erro ao aplicar tarifa de depósito: " + e.getMessage());
        }
        quantidadeTransacoes++;
    }
}