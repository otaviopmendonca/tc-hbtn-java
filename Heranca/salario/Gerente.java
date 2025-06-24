public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo); 
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            double bonus = super.getSalarioFixo() * 0.20; 
            double diferenca = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
            bonus += diferenca * 0.01; 
            return bonus;
        } else {
            return 0.0; 
        }
    }
}