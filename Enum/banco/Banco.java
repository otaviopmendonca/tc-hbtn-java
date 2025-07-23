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

        if (agenciaExistente != null) { //agencia existe
            System.out.println("A agência " + nomeAgencia + " já existe e não pode ser adicionada novamente.");
            return false;
        } else { //agencia nao existe
            Agencia novaAgencia = new Agencia(nomeAgencia);
            this.agencias.add(novaAgencia);
            System.out.println("Agência '" + nomeAgencia + "' adicionada com sucesso.");
            return true;
        }
    }

    public boolean adicionarCliente(String nomeAgencia, String nomeCliente, double valorTransacaoInicial) {

    }

}

/*Possui dois campos, uma String chamado nome e um ArrayList que contém objetos do tipo Agencia chamada agencias.

Um construtor que recebe uma String (nome do banco). Ele inicializa o nome e instancia agencias.

Deve possuir cinco métodos, são eles (suas funções estão em seus nomes):
buscarAgencia, possui um parâmetro do tipo String (nome da agência) e retorna uma Agencia. Retorna a agência se existir ou null caso contrário.

adicionarAgencia, possui um parâmetro do tipo String (nome da agência) e retorna um valor boolean. 
Ele retorna true se a agência foi adicionada com sucesso ou false caso contrário. 
Não deve incluir agência já existente, deve verificar através do método buscarAgencia.

adicionarCliente, possui três parâmetros do tipo String (nome da agência), String (nome do cliente), double (valor da transação inicial) 
e retorna um boolean. 
O cliente pertence a uma agência. Não deve incluir cliente já existente na agência, verificar através do método buscarCliente,
método da classe Agencia descrito mais abaixo. Retorna true se o cliente foi adicionado com sucesso ou false caso contrário.

adicionarTransacaoCliente, possui três parâmetros do tipo String (nome da agência), String (nome do cliente), double (valor da transação) 
e retorna um boolean. Retorna true se a transação do cliente foi adicionada com sucesso ou false caso contrário. 
Verificar se cliente existe (buscarCliente) e se agência existe (buscarAgencia), não deve incluir transação se cliente ou agência não existir.

listarClientes, possui dois parâmetros do tipo String (nome da agência), boolean (imprime transações) e retorna um boolean. 
Retorna true se a agência existir ou false caso contrário (utilizar buscarAgencia). Este método imprime uma lista de clientes. 
Deve listar da seguinte forma: */