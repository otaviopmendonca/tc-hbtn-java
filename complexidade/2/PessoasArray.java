public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        int inicio = 0;
        int fim = nomes.length - 1;
        int posicao = -1;
        boolean encontrado = false;

        System.out.println("Procurando o nome: \"" + nome + "\"");

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2; // Evita overflow para grandes valores de inicio e fim
            System.out.println("Passando pelo indice: " + meio);

            int comparacao = nome.compareTo(nomes[meio]);

            if (comparacao == 0) { // Encontrou o nome
                posicao = meio;
                encontrado = true;
                break; // Sai do loop assim que encontra para otimização
            } else if (comparacao < 0) { // Nome procurado está à esquerda do meio
                fim = meio - 1;
            } else { // Nome procurado está à direita do meio
                inicio = meio + 1;
            }
        }

        if (encontrado) {
            System.out.println("Nome " + nome + " encontrado na posição " + posicao);
        } else {
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
        }
    }
}
