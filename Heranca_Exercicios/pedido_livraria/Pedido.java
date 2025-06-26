public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

   
    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        if (percentualDesconto < 0 || percentualDesconto > 100) {
            throw new IllegalArgumentException("Percentual de desconto deve ser entre 0 e 100.");
        }
        if (itens == null) {
            throw new IllegalArgumentException("A lista de itens do pedido não pode ser nula.");
        }
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public double calcularTotal() {
        // Verificação Inicial: Itens nulos ou vazios
        if (this.itens == null || this.itens.length == 0) {
            return 0.0;
        }

        //  Inicialização do Total Bruto
        double totalBruto = 0.0;

        //  Iteração sobre os Itens do Pedido
        for (ItemPedido item : this.itens) {
            if (item == null || item.getProduto() == null) {
                System.err.println("Aviso: Item de pedido ou seu produto é nulo e será ignorado.");
                continue;
            }
            if (item.getQuantidade() <= 0) {
                System.err.println("Aviso: Item com quantidade não positiva (" + item.getQuantidade() + ") e será ignorado.");
                continue;
            }

            double precoLiquidoProduto = item.getProduto().obterPrecoLiquido();
            totalBruto += precoLiquidoProduto * item.getQuantidade();
        }

        //  Aplicação do Desconto
        double valorDesconto = totalBruto * (this.percentualDesconto / 100.0);
        double totalComDesconto = totalBruto - valorDesconto;

        // Garantir Total Não Negativo
        if (totalComDesconto < 0) {
            totalComDesconto = 0.0;
        }

       
        return totalComDesconto;
    }
}