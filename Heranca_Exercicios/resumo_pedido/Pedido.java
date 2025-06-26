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

     public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;

        for (ItemPedido item : itens) {
            if (item != null && item.getProduto() != null) {
                String tipo = item.getProduto().getClass().getSimpleName();
                String titulo = item.getProduto().getTitulo();
                double preco = item.getProduto().obterPrecoLiquido();
                int quantidade = item.getQuantidade();
                double totalItem = preco * quantidade;
                totalProdutos += totalItem;

                System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                        tipo, titulo, preco, quantidade, totalItem);
            }
        }
        System.out.println("----------------------------");

        double valorDesconto = totalProdutos * (this.percentualDesconto / 100.0);
        double totalPedido = totalProdutos - valorDesconto;

        System.out.printf("DESCONTO: %.2f%n", valorDesconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido);
        System.out.println("----------------------------");
    }
}