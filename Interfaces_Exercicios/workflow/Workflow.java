import atividades.Atividade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Workflow {
    private final List<Atividade> atividades;

    public Workflow() {
        this.atividades = new ArrayList<>();
    }

    public void registrarAtividade(Atividade atividade) {
        if (atividade == null) {
            throw new IllegalArgumentException("Atividade não pode ser nula.");
        }
        this.atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return Collections.unmodifiableList(atividades);
    }

    public boolean estaVazio() {
        return this.atividades.isEmpty();
    }
}