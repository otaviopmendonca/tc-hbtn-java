public class Departamento {
    double valorMeta;
    double valorAtingidoMeta;

    Departamento (double valorMeta, double valorAtingidoMeta) {
        this.valorMeta = valorMeta;
        this.valorAtingidoMeta = valorAtingidoMeta;
    }

    public double getValorMeta() {
        return valorMeta;
    }

    public double getValorAtingidoMeta() {
        return valorAtingidoMeta;
    }
    
     public boolean alcancouMeta() {
        return valorAtingidoMeta >= valorMeta;
     }
}
