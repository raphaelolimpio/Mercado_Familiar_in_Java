package componentes.controleEstoque.controle.busca.setor;

import java.util.ArrayList;
import java.util.List;

import componentes.controleEstoque.produto.alimenticios.Alimentocios;
import componentes.controleEstoque.produto.eletronicos.Eletronicos;
import componentes.controleEstoque.produto.listaProdutosAll.ListaProdutosAll;

public class BuscarPrudutoSetor {

    private ListaProdutosAll listaProdutosAll;
    
    public BuscarPrudutoSetor(ListaProdutosAll listaProdutosAll) {
        this.listaProdutosAll = listaProdutosAll;
    }

    public List<Object> buscarPorSetor(String setor){
        List<Object> produtoNoSetor = new ArrayList<>();

        for (Object produto : listaProdutosAll.getProdutos()){
            if (produto instanceof Alimentocios) {
                Alimentocios alimenticio = (Alimentocios) produto;
                if (alimenticio.getSetor().equalsIgnoreCase(setor)){
                    produtoNoSetor.add(alimenticio);
                }
            } else if (produto instanceof Eletronicos) {
                Eletronicos eletronicos = (Eletronicos) produto;
                if(eletronicos.getSetor().equalsIgnoreCase(setor)){
                    produtoNoSetor.add(eletronicos);
                }
            }
        }
        return produtoNoSetor;
    }
    
}
