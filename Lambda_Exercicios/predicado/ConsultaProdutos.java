import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConsultaProdutos {
    
    public static List<Produto> filtrar(List<Produto> produtos, Predicate<Produto> criterioFiltro) {
        ArrayList<Produto> filtrados = new ArrayList<Produto>();
        for (Produto p : produtos) {
            if (criterioFiltro.test(p)) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }
}
