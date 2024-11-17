package componentes.controleEstoque.controle.busca.unidade;
import componentes.CaixaGeral.venda.ListaPrdutosCaixa.ListaProdutosCaixa;
import componentes.controleEstoque.produto.alimenticios.Alimentocios;
import componentes.controleEstoque.produto.eletronicos.Eletronicos;



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

    public Object buscarPorId(int id) {
   
        for (Object produto : listaProdutosCaixa.getProdutos()) {
            if (produto instanceof Alimentocios) {
                Alimentocios alimenticio = (Alimentocios) produto;
                if (alimenticio.getIdAlimenticios() == id) {
                    return alimenticio; 
                }
            } else if (produto instanceof Eletronicos) {
                Eletronicos eletronico = (Eletronicos) produto;
                if (eletronico.getIdEletronicos() == id) {
                    return eletronico;
                }
            }
        }
        return null; 
    }
}
