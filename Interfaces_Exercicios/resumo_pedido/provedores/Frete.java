package provedores;

public class Frete {
    protected double valor;
    protected TipoProvedorFrete tipoProvedorFrete;

    public Frete(double valor, TipoProvedorFrete tipoProvedorFrete) {
        this.valor = valor;
        this.tipoProvedorFrete = tipoProvedorFrete;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(){
        this.valor = valor;
    }

    public TipoProvedorFrete getTipoProvedorFrete(){
        return this.tipoProvedorFrete;
    }

    public void setTipoProvedorFrete() {
        this.tipoProvedorFrete = tipoProvedorFrete;
    }
}