import java.util.*;
import java.util.Iterator;

public class Pedido {
    
    private ArrayList<PedidoCookie> cookies;

    public Pedido(){
        this.cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        this.cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas() {
        int totalCaixas = 0;
        for (PedidoCookie cookie : cookies) {
            totalCaixas += cookie.getQuantidadeCaixas();
        }
        return totalCaixas;
    }

    public int removerSabor(String sabor) {
        int totalRemovido = 0;
        Iterator<PedidoCookie> iterator = cookies.iterator();
        
        while (iterator.hasNext()) {
            PedidoCookie cookie = iterator.next();
            if (cookie.getSabor().equals(sabor)) {
                totalRemovido += cookie.getQuantidadeCaixas();
                iterator.remove();
            }
        }
        
        return totalRemovido;
    }
}
