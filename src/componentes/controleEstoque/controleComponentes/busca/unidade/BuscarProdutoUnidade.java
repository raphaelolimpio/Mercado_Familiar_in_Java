package componentes.controleEstoque.controleComponentes.busca.unidade;
import componentes.CaixaComponentes.vendas.ListaPrdutosCaixa.ListaProdutosCaixa;
import componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios;
import componentes.controleEstoque.produtoComponentes.eletronicos.Eletronicos;



public class BuscarProdutoUnidade {
    
    private ListaProdutosCaixa listaProdutosCaixa;

    public Object buscarPorNome(String nome) {


        for (Object produto : listaProdutosCaixa.getProdutos()) {
            if (produto instanceof Alimentocios) {
                Alimentocios alimenticio = (Alimentocios) produto;
                if (alimenticio.getNomeAlimenticios().equalsIgnoreCase(nome)) {
                    return alimenticio; 
                }
            } else if (produto instanceof Eletronicos) {
                Eletronicos eletronico = (Eletronicos) produto;
                if (eletronico.getNomeEletronicos().equalsIgnoreCase(nome)) {
                    return eletronico; 
                }
            }
        }
        return null; 
    }

    public Object buscarPorId(String id) {
   
        for (Object produto : listaProdutosCaixa.getProdutos()) {
            if (produto instanceof Alimentocios) {
                Alimentocios alimenticio = (Alimentocios) produto;
                if (alimenticio.getIdAlimenticios().equals(id)) {
                    return alimenticio; 
                }
            } else if (produto instanceof Eletronicos) {
                Eletronicos eletronico = (Eletronicos) produto;
                if (eletronico.getIdProduto().equals(id)) {
                    return eletronico;
                }
            }
        }
        return null; 
    }
}
