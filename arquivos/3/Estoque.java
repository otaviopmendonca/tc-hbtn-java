import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Estoque {
    private List<Produto> produtos;
    private String arquivoCsv;
    private int proximoId; // Para gerar IDs sequenciais

    public Estoque(String arquivoCsv) {
        this.arquivoCsv = arquivoCsv;
        this.produtos = new ArrayList<>();
        this.proximoId = 1; // Começa com ID 1
        carregarEstoque();
    }

    // Carrega os produtos do arquivo CSV para a lista em memória
    private void carregarEstoque() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCsv))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dados = line.split(",");
                if (dados.length == 4) {
                    try {
                        int id = Integer.parseInt(dados[0]);
                        String nome = dados[1];
                        int quantidade = Integer.parseInt(dados[2]);
                        double preco = Double.parseDouble(dados[3]);
                        produtos.add(new Produto(id, nome, quantidade, preco));
                        if (id >= proximoId) { // Atualiza o próximo ID disponível
                            proximoId = id + 1;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao parsear dados no CSV: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Arquivo CSV não encontrado ou erro de leitura: " + e.getMessage());
            // Se o arquivo não existir, ele será criado na primeira gravação
        }
    }

    // Salva a lista de produtos atual para o arquivo CSV
    private void salvarEstoque() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCsv))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar o estoque no arquivo CSV: " + e.getMessage());
        }
    }

    // Adiciona um novo produto
    public void adicionarProduto(String nome, int quantidade, double preco) {
        // Validação de entrada
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do produto não pode ser vazio.");
            return;
        }
        if (quantidade <= 0) {
            System.out.println("Quantidade deve ser um número positivo.");
            return;
        }
        if (preco <= 0) {
            System.out.println("Preço deve ser um número positivo.");
            return;
        }

        // Verifica se já existe um produto com o mesmo nome (opcional, mas boa prática)
        Optional<Produto> produtoExistente = produtos.stream()
                                                     .filter(p -> p.getNome().equalsIgnoreCase(nome))
                                                     .findFirst();
        if (produtoExistente.isPresent()) {
            System.out.println("Um produto com este nome já existe. Considere atualizar a quantidade.");
            return;
        }

        Produto novoProduto = new Produto(proximoId++, nome, quantidade, preco);
        produtos.add(novoProduto);
        salvarEstoque();
        System.out.println("Produto adicionado com sucesso: " + novoProduto.toString());
    }

    // Exclui um produto pelo ID
    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarEstoque();
            System.out.println("Produto com ID " + id + " excluído com sucesso.");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    // Exibe todos os produtos no estoque
    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p.toString());
            }
        }
    }

    // Atualiza a quantidade de um produto pelo ID
    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) {
            System.out.println("A nova quantidade não pode ser negativa.");
            return;
        }

        Optional<Produto> produtoOpt = produtos.stream()
                                             .filter(p -> p.getId() == id)
                                             .findFirst();

        if (produtoOpt.isPresent()) {
            produtoOpt.get().setQuantidade(novaQuantidade);
            salvarEstoque();
            System.out.println("Quantidade do produto ID " + id + " atualizada para " + novaQuantidade + ".");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }
}