import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutos {
    
    public static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterioFiltro) {
        ArrayList<Produto> filtrados = new ArrayList<Produto>();
        for (Produto p : produtos) {
            if (criterioFiltro.testar(p)) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }
}
