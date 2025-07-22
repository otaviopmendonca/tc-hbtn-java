public class NumerosPares {

    public static void main(String[] args) {
        String numeros = "";

        for (int i = 0; i <= 98; i += 2) {
            numeros += i;
            if (i < 98) {
                numeros += ", ";
            }
        }
        System.out.println(numeros);
    }
}