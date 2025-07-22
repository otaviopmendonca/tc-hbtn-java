public class InteiroPositivo {
    
    private int valor;

    public InteiroPositivo(int valor) {
        setValor(valor);
    }

    public InteiroPositivo(String valor) {
        setValor(Integer.parseInt(valor));
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor nao eh um valor inteiro positivo");
        }
        this.valor = valor;
    }

    public boolean ehPrimo() {
        if (valor < 2)
            return false;

        for (int i = 2; i * i <= valor; i++) {
            if (valor % i == 0)
                return false;
        }
        return true;
    }
}
