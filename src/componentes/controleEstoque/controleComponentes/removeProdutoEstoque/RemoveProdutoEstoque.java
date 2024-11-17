package componentes.controleEstoque.controleComponentes.removeProdutoEstoque;

import componentes.controleEstoque.produtoComponentes.listaProdutosAll.ListaProdutosAll;

public class RemoveProdutoEstoque {

    private ListaProdutosAll listaProdutos;

    public RemoveProdutoEstoque(ListaProdutosAll listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public boolean removerProdutoNome(String nome) {
        Object produtoRemover = null;

        for (Object produto : listaProdutos.getProdutos()) {
            if (produto instanceof componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios) {
                componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios alimentocio = (componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios) produto;
                if (alimentocio.getNomeAlimenticios().equalsIgnoreCase(nome)) {
                    produtoRemover = alimentocio;
                    break;
                }
            } else if (produto instanceof componentes.controleEstoque.produtoComponentes.eletronicos.Eletronicos) {
                componentes.controleEstoque.produtoComponentes.eletronicos.Eletronicos eletronico = (componentes.controleEstoque.produtoComponentes.eletronicos.Eletronicos) produto;
                if (eletronico.getNomeEletronicos().equalsIgnoreCase(nome)) {
                    produtoRemover = eletronico;
                    break;
                }
            }
        }
        if (produtoRemover != null) {
            listaProdutos.getProdutos().remove(produtoRemover);
            System.out.println("Produto removido: " + produtoRemover.toString());
            return true;
        } else {
            System.out.println("Produto não encontrado: " + nome);
            return false;
        }

    }

    
}
