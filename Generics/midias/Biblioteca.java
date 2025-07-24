import java.util.ArrayList;
import java.util.List;

public class Biblioteca<T extends Midia> { // T deve ser Midia ou uma subclasse de Midia
    private List<T> listaMidias;
    
    public Biblioteca() {
        this.listaMidias = new ArrayList<>();
    }

    public void adicionarMidia(T midia) {
        if (midia != null) { //midia existe
            listaMidias.add(midia);
        } else { //midia nao existe
        }
    }

    public List<T> obterListaMidias() {
        return listaMidias;
    }
}