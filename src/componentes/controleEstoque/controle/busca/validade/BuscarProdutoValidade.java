package componentes.controleEstoque.controle.busca.validade;

import java.util.ArrayList;
import java.util.List;

import componentes.controleEstoque.produto.alimenticios.Alimentocios;
import componentes.controleEstoque.produto.listaProdutosAll.ListaProdutosAll;

public class BuscarProdutoValidade {
     private ListaProdutosAll listaProdutosAll;
    
    public BuscarProdutoValidade(ListaProdutosAll listaProdutosAll) {
        this.listaProdutosAll = listaProdutosAll;
    }

    public List<Object> buscarPorValidade(String validade){
        List<Object> produtoValidade = new ArrayList<>();

        for (Object produto : listaProdutosAll.getProdutos()){
            if (produto instanceof Alimentocios) {
                Alimentocios alimenticio = (Alimentocios) produto;
                if (alimenticio.getValidadeAlimenticios().equalsIgnoreCase(validade)){
                    produtoValidade.add(alimenticio);
                }
            } 
        }
        return produtoValidade;
    }
}
