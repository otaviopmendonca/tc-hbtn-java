import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private ArrayList<Produto> produtos;
    private String arquivoCSV;

    public Estoque(String arquivoCSV) {
        this.arquivoCSV = arquivoCSV;
        this.produtos = new ArrayList<>();
        carregarEstoque();
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        produtos.add(new Produto(proximoId(), nome, quantidade, preco));
        salvarEstoque();
    }

    public void excluirProduto(int id) {
        produtos.removeIf(p -> p.getId() == id);
        salvarEstoque();
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setQuantidade(novaQuantidade);
                break;
            }
        }
        salvarEstoque();
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    private void carregarEstoque() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] data = linha.split(",");
                Produto produto = new Produto(Integer.parseInt(data[0]), data[1],
                        Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                if (produto != null) {
                    produtos.add(produto);
                }
            }
        } catch (IOException e) {
            // Se o arquivo não existir na primeira execução, ele será criado depois.
            if (!(e instanceof FileNotFoundException)) {
                System.err.println("Erro ao carregar estoque: " + e.getMessage());
            }
        }
    }

    private void salvarEstoque() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCSV))) {
            for (Produto produto : produtos) {
                bw.write(produto.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }

    private int proximoId(){
        int id=0;
        for (Produto pdto: produtos) {
            if(id < pdto.getId()){
                id= pdto.getId();
            }
        }
        id++;
        return id;
    }
}