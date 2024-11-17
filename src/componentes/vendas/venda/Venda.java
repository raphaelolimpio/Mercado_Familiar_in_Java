package componentes.vendas.venda;

import componentes.controleEstoque.produtoComponentes.produto.Produto;
import componentes.vendas.ListaPrdutosCaixa.ListaProdutosCaixa;

public class Venda {
    private ListaProdutosCaixa listaProdutosCaixa;

    public Venda(ListaProdutosCaixa listaProdutosCa) {
        this.listaProdutosCaixa = listaProdutosCa;
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : listaProdutosCaixa.getProdutos()) {
            total += produto.getValorProduto() * produto.getQuantidadeProduto();
        }
        return total;
    }
}
