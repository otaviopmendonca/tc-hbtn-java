import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> numeros, int numero) {
        // i = posicao do elemento (numero)
        for(int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == numero) { //verifica se o elemento na posicao i = ao numero buscado
                return i; //retorna a posicao do numero buscado
            }
        }
        return -1;
    }

    public static void adicionarNumero(List<Integer> numeros, int numero) {
        if (buscarPosicaoNumero(numeros, numero) != -1) { //numero existe
            throw new IllegalArgumentException("Numero jah contido na lista");
        } else { // numero nao existe
        numeros.add(numero); 
        }
    }

    public static void removerNumero(List<Integer> numeros, int numero) {
        if (buscarPosicaoNumero(numeros, numero) == -1) { //numero nao existe
            throw new IllegalArgumentException("Numero nao encontrado na lista");
        } else {   //numero existe
        numeros.remove(Integer.valueOf(numero));
        }
    }

    public static void substituirNumero(List<Integer> numeros, int numeroSubstituir, int numeroSubstituto) {
        int indice = buscarPosicaoNumero(numeros, numeroSubstituir); // encontra a posição do número a ser substituído
        if (indice != -1) { // numeroSubstituir existe 
            numeros.set(indice, numeroSubstituto); // substitui o número na posição encontrada
        } else { // numeroSubstituir não existe
            numeros.add(numeroSubstituto); 
        }
    }  
}
