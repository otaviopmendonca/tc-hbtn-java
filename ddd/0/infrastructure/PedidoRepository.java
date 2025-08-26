package infrastructure;


import java.util.HashMap;
import java.util.Map;


import domain.Pedido;


public class PedidoRepository {


    private final Map<String, Pedido> pedidos = new HashMap<>();


    public void salvar(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }

    public Pedido buscarPorId(String id) {
        if (!pedidos.containsKey(id)) {
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
        return pedidos.get(id);
    }
}