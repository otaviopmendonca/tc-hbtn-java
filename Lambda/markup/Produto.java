import java.util.function.*;

public class Produto {
    
    private String nome;
    private double preco;
    private double percentualMarkup = 10;

    public Supplier<Double> precoComMarkup = () -> this.getPreco() * (1 + (this.percentualMarkup / 100));
    public Consumer<Double> atualizarMarkup = x -> this.percentualMarkup = x;
    
    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}