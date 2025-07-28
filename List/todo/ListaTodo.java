import java.util.ArrayList;
import java.util.List;

public class ListaTodo {

    private ArrayList<Tarefa> tarefas;

    public ListaTodo(){
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {

        if (tarefa.getDescricao() == null || tarefa.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }
        
        for (Tarefa t : tarefas) { // t é a ja existente e tarefa é a nova

            if (t.getIdentificador() == tarefa.getIdentificador()) { // se identificador novo for igual ao já existente
                throw new IllegalArgumentException("Tarefa com identificador " + tarefa.getIdentificador() + " ja existente na lista");
            }
        } // se nao existir tarefa com identificador novo
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int identificador) {
        for (Tarefa tarefa : tarefas) { // tarefa é a existente e o identifiacdor do parametro é da tarefa nova

            if (tarefa.getIdentificador() == identificador) {
                tarefa.setEstahFeita(true);
                return true;
            }
        }
        return false;
    }

    public boolean desfazerTarefa(int identificador) {
        for (Tarefa tarefa : tarefas) { // tarefa é a existente e o identifiacdor do parametro é da tarefa nova

            if (tarefa.getIdentificador() == identificador) {
                tarefa.setEstahFeita(false);
                return true;
            }
        }
        return false;
    }

    public void desfazerTodas() {
        for (Tarefa tarefa : tarefas) {
            tarefa.setEstahFeita(false);
        }
    }

    public void fazerTodas() {
        for (Tarefa tarefa : tarefas) {
            tarefa.setEstahFeita(true);
        }
    }

    public void listarTarefas() {
        for (Tarefa tarefa : tarefas) {
            String status = tarefa.isEstahFeita() ? "[X]" : "[ ]";
            System.out.println(status + "  Id: " + tarefa.getIdentificador() + " - Descricao: " + tarefa.getDescricao());
        }   
    }
}   
