package componentes.vendas.ListaPrdutosCaixa;

import java.util.ArrayList;
import java.util.List;

import componentes.controleEstoque.produtoComponentes.produto.Produto;

public class ListaProdutosCaixa {
    
    public List<Produto> produtos;

    public ListaProdutosCaixa() {
        produtos = new ArrayList<>();
    }

    public void addProdutos(Produto produto, int quantidade) {
        produtos.add(produto);
        System.out.println("produto adicionado: " + produto);
    }
    public void listaProdutos() {
        System.out.println("ListaProdutos: ");
        for (Object produto : produtos){
            System.out.println("- " + produto.toString());
        }

    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    
}
