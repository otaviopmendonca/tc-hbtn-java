import java.util.ArrayList;

public class Cliente {
    private String nome;
    private ArrayList<Double> transacoes;

    public Cliente(String nome, double transacaoInicial) {
        this.nome = nome;
        this.transacoes = new ArrayList<>();
        adicionarTransacao(transacaoInicial);
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Double> getTransacoes() {
        return transacoes;
    }

    public void adicionarTransacao(double valor) {
        this.transacoes.add(valor);
    }
}