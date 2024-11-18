package componentes.vendas.ListaPrdutosCaixa;

import java.util.ArrayList;
import java.util.List;

import componentes.controleEstoque.produtoComponentes.produto.Produto;


public class ListaProdutosCaixa {
    private List<Produto> produtosNoCaixa;

    public ListaProdutosCaixa() {
        produtosNoCaixa = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtosNoCaixa;
    }

    public void addProdutos(Produto produto, int quantidade) {
        for (Produto p : produtosNoCaixa) {
            if (p.getIdProduto().equals(produto.getIdProduto())) {
                p.setQuantidadeProduto(p.getQuantidadeProduto() + quantidade);  // Atualiza quantidade no caixa
                return;
            }
        }
        produto.setQuantidadeProduto(quantidade);
        produtosNoCaixa.add(produto);
    }

    public void removerProduto(Produto produto, int quantidade) {
        for (Produto p : produtosNoCaixa) {
            if (p.getIdProduto().equals(produto.getIdProduto())) {
                int novaQuantidade = (int) (p.getQuantidadeProduto() - quantidade);
                if (novaQuantidade <= 0) {
                    produtosNoCaixa.remove(p);  // Remove o produto completamente se a quantidade for 0 ou negativa
                } else {
                    p.setQuantidadeProduto(novaQuantidade);  // Atualiza quantidade do produto
                }
                return;
            }
        }
    }
}
