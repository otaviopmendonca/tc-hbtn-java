public class PrintFormatacaoNumeros {
    public static void main(String[] args) {
        float taxa = 0.2456f;
        float valor = 7654.321f;
        
        System.out.printf("Valor: R$ %,.3f\n", valor);
        System.out.printf("Taxa: %.2f%%\n", taxa);
    }
}