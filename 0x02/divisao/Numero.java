public class Numero {

    public static void dividir(int a, int b) {
        int resultado = 0; 

        try {
            resultado = a / b; 
        } catch (ArithmeticException e) {
         
            System.out.println("Nao eh possivel dividir por zero");
            
        } finally {
            System.out.println(a + " / " + b + " = " + resultado);
        }
    }
    public static void main(String[] args) {
        // Exemplos de uso:
        Numero.dividir(4, 3);
        Numero.dividir(9, 0);
        Numero.dividir(10, 2);
    }
}