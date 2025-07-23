import java.util.ArrayList;

public class Banco {

    private String nome;
    private ArrayList<Agencia> agencias;

    public Banco(String nomeBanco) {
        this.nome = nomeBanco;
        this.agencias = new ArrayList<>();
    }

    public Agencia buscarAgencia(String nomeAgencia) {
        for (Agencia agenciaAtual : this.agencias) {
            if (agenciaAtual.getNome().equalsIgnoreCase(nomeAgencia)) {
                return agenciaAtual;
            }
        }
        return null;
    }

    public boolean adicionarAgencia(String nomeAgencia) {
        Agencia agenciaExistente = buscarAgencia(nomeAgencia);

        if (agenciaExistente != null) { // agencia existe
            return false;
        } else { // agencia nao existe
            Agencia novaAgencia = new Agencia(nomeAgencia);
            this.agencias.add(novaAgencia);
            return true;
        }
    }

    public boolean adicionarCliente(String nomeAgencia, String nomeCliente, double valorTransacaoInicial) {
        // 1. Busca a agência pelo nome
        Agencia agencia = buscarAgencia(nomeAgencia);

        // 2. Verifica se a agência foi encontrada
        if (agencia == null) {
            return false; // A agência não existe, então não pode adicionar o cliente
        } else {
            // 3. Se a agência existe, delega a tarefa para o método novoCliente daquela agência
            // O método novoCliente da Agência já faz a verificação se o cliente existe nela.
            return agencia.novoCliente(nomeCliente, valorTransacaoInicial);
        }
    }

    // --- MÉTODOS ADICIONADOS/CORRIGIDOS ---

    public boolean adicionarTransacaoCliente(String nomeAgencia, String nomeCliente, double valorTransacao) {
        Agencia agencia = buscarAgencia(nomeAgencia);
        if (agencia != null) {
            // Delega a responsabilidade de adicionar a transação para a agência
            return agencia.adicionarTransacaoCliente(nomeCliente, valorTransacao);
        }
        return false; // Agência não encontrada
    }

    public boolean listarClientes(String nomeAgencia, boolean imprimeTransacoes) {
        Agencia agencia = buscarAgencia(nomeAgencia);
        if (agencia != null) {
            System.out.println("Agência: " + agencia.getNome());
            ArrayList<Cliente> clientesAgencia = agencia.getClientes();
            if (clientesAgencia.isEmpty()) {
                System.out.println("  Nenhum cliente cadastrado nesta agência.");
                return true; // Retorna true porque a agência existe, mesmo que sem clientes.
            }
            for (int i = 0; i < clientesAgencia.size(); i++) {
                Cliente cliente = clientesAgencia.get(i);
                System.out.println("  Cliente: " + cliente.getNome() + " [" + (i + 1) + "]");
                if (imprimeTransacoes) {
                    ArrayList<Double> transacoesCliente = cliente.getTransacoes();
                    for (int j = 0; j < transacoesCliente.size(); j++) {
                        System.out.printf("    [%d] valor %.2f%n", (j + 1), transacoesCliente.get(j));
                    }
                }
            }
            return true;
        }
        System.out.println("Agência '" + nomeAgencia + "' não encontrada.");
        return false; // Agência não encontrada
    }
}