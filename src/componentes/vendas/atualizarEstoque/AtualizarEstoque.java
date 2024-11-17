package componentes.vendas.atualizarEstoque;

import componentes.controleEstoque.produtoComponentes.listaProdutosAll.ListaProdutosAll;
import componentes.controleEstoque.produtoComponentes.produto.Produto;
import componentes.vendas.ListaPrdutosCaixa.ListaProdutosCaixa;

public class AtualizarEstoque {
    private ListaProdutosAll estoque;

    public AtualizarEstoque(ListaProdutosAll estoque) {
        this.estoque = estoque;
    }

    public void atualizarEstoque(ListaProdutosCaixa produtosCaixa) {
        for (Produto produtoCaixa : produtosCaixa.getProdutos()) {
            for (Produto produtoEstoque : estoque.getProdutos()) {
                if (produtoCaixa.getIdProduto().equals(produtoEstoque.getIdProduto())) {
                    int novaQuantidade = (int) (produtoEstoque.getQuantidadeProduto() - produtoCaixa.getQuantidadeProduto());
                    if (novaQuantidade < 0) {
                        System.out.println("Quantidade insuficiente para o produto: " + produtoEstoque.getNomeProduto());
                    } else {
                        produtoEstoque.setQuantidadeProduto(novaQuantidade);
                        System.out.println("Estoque atualizado: " + produtoEstoque.getNomeProduto() + " - Nova quantidade: " + novaQuantidade);
                    }
                    break;
                }
            }
        }
    }
}
