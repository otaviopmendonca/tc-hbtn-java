import java.util.ArrayList;

public class Celular {
    private ArrayList<Contato> contatos;

    public Celular() {
        this.contatos = new ArrayList<>();
    }

    public int obterPosicaoContato(String nome) {
        for (int i=0; i<this.contatos.size(); i++) {
            Contato contatoAtual = this.contatos.get(i); 

            if (contatoAtual.getNome().equals(nome)) { 
                return i; 
            }
        }
        return -1; // Retorne -1 se não encontrar
    }
    
    public void adicionarContato(Contato novoContato) throws Exception {
        int posicao = obterPosicaoContato(novoContato.getNome()); // Verifica se o contato já existe usando o nome

        if(posicao != -1) {
            throw new Exception("Nao foi possivel adicionar contato. Contato jah existente com esse nome.");
        } else {
            this.contatos.add(novoContato);
        }
    }

    public void atualizarContato(Contato contatoAntigo, Contato novoContato) throws Exception {
        int posicaoContatoAntigo = obterPosicaoContato(contatoAntigo.getNome()); // Verifica se o contato já existe usando o nome

        if(posicaoContatoAntigo == -1) {
            throw new Exception("Nao foi possivel modificar contato. Contato nao existe.");
        }  

        int posicaoNovoContato = obterPosicaoContato(novoContato.getNome());

        if (posicaoNovoContato != -1 && posicaoNovoContato != posicaoContatoAntigo) {
            throw new Exception("Nao foi possivel modificar contato. Contato jah existente com esse nome.");
        }
        // Se ambas as verificações passarem, atualiza o contato
        Contato contatoParaAtualizar = this.contatos.get(posicaoContatoAntigo);
        contatoParaAtualizar.setNome(novoContato.getNome());
        contatoParaAtualizar.setNumeroTelefone(novoContato.getNumeroTelefone());
        contatoParaAtualizar.setTipo(novoContato.getTipo());
    }

    public void removerContato(Contato contato) throws Exception {
        int posicao = obterPosicaoContato(contato.getNome());

        if(posicao == -1) {
            throw new Exception("Nao foi possivel remover contato. Contato nao existe.");
        } else {
            this.contatos.remove(posicao);
        }
    }

    public void listarContatos() {
        for (Contato contato : this.contatos) {
            System.out.println(contato.getNome() + " -> " + contato.getNumeroTelefone() + " (" + contato.getTipo() + ")");
        }
    }
}