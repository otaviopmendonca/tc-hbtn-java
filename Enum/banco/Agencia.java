import java.util.ArrayList;

public class Agencia {
    
    private String nome;
    private ArrayList<Cliente> clientes;

    public Agencia(String nomeAgencia) {
        this.nome = nomeAgencia;
        this.clientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public boolean novoCliente(String nomeCliente, double valorTransacaoInicial) {
        Cliente clienteExistente = buscarCliente(nomeCliente);

        if (clienteExistente != null) {
            // Cliente já existe, não adiciona e retorna false
            return false;
        } else {
            // Cliente não existe, cria uma nova instância de Cliente e adiciona à lista
            Cliente novoCliente = new Cliente(nomeCliente, valorTransacaoInicial);
            this.clientes.add(novoCliente);
            return true;
        }
    }

    public boolean adicionarTransacaoCliente(String nomeCliente, double valorTransacaoInicial) {
        Cliente clienteExistente = buscarCliente(nomeCliente);
        if (clienteExistente != null) {
            clienteExistente.adicionarTransacao(valorTransacaoInicial);
            return true;
        }
        return false;
    }

    public Cliente buscarCliente(String nomeCliente) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getNome().equals(nomeCliente)) {
                return cliente;
            }
        }
        return null;
    }

}
