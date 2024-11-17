package componentes.CaixaGeral.venda.ListaPrdutosCaixa;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutosCaixa {
    
    public List<Object> produtos;

    public ListaProdutosCaixa() {
        produtos = new ArrayList<>();
    }

    public void addProdutos(Object produto) {
        produtos.add(produto);
        System.out.println("produto adicionado: " + produto);
    }
    public void listaProdutos() {
        System.out.println("ListaProdutos: ");
        for (Object produto : produtos){
            System.out.println("- " + produto.toString());
        }

    }

    public List<Object> getProdutos() {
        return produtos;
    }

    
}
