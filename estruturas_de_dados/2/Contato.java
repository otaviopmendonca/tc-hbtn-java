import java.util.*;

public class Contato {
    private List<String> telefones;
    private Set<String> emails;

    // Construtor
    public Contato() {
        telefones = new ArrayList<>();
        emails = new HashSet<>();
    }

    // Adiciona um telefone
    public void adicionarTelefone(String telefone) {
        telefones.add(telefone);
    }

    // Adiciona um email
    public boolean adicionarEmail(String email) {
        if (!emails.contains(email)) {
            emails.add(email);
            return true;
        }
        return false;
    }

    // Exibe os detalhes do contato
    public void exibirContato() {
        System.out.println("Telefones: " + telefones);
        System.out.println("Emails: " + emails);
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public Set<String> getEmails() {
        return emails;
    }
}
