package componentes.controleEstoque.controle.busca.garantia;

import java.util.ArrayList;
import java.util.List;

import componentes.caixa.venda.lista.todosProdutos.ListaProdutosAll;
import componentes.controleEstoque.produto.eletronicos.Eletronicos;

public class BuscarProdutoGarantia {
    private ListaProdutosAll listaProdutosAll;
    
    public BuscarProdutoGarantia(ListaProdutosAll listaProdutosAll) {
        this.listaProdutosAll = listaProdutosAll;
    }

    public List<Object> buscarPorGarantia(String garantia){
        List<Object> produtoNaGarantia = new ArrayList<>();

        for (Object produto : listaProdutosAll.getProdutos()){
            if (produto instanceof Eletronicos) {
                Eletronicos eletronicos = (Eletronicos) produto;
                if(eletronicos.getGarantiaEletronicos().equalsIgnoreCase(garantia)){
                    produtoNaGarantia.add(eletronicos);
                }
            }
        }
        return produtoNaGarantia;
    }
}
