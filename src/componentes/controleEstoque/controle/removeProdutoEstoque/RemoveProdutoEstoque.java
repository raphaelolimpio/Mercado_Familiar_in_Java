package componentes.controleEstoque.controle.removeProdutoEstoque;

import componentes.controleEstoque.produto.listaProdutosAll.ListaProdutosAll;

public class RemoveProdutoEstoque {

    private ListaProdutosAll listaProdutos;

    public RemoveProdutoEstoque(ListaProdutosAll listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public boolean removerProdutoNome(String nome) {
        Object produtoRemover = null;

        for (Object produto : listaProdutos.getProdutos()) {
            if (produto instanceof componentes.controleEstoque.produto.alimenticios.Alimentocios) {
                componentes.controleEstoque.produto.alimenticios.Alimentocios alimentocio = (componentes.controleEstoque.produto.alimenticios.Alimentocios) produto;
                if (alimentocio.getNomeAlimenticios().equalsIgnoreCase(nome)) {
                    produtoRemover = alimentocio;
                    break;
                }
            } else if (produto instanceof componentes.controleEstoque.produto.eletronicos.Eletronicos) {
                componentes.controleEstoque.produto.eletronicos.Eletronicos eletronico = (componentes.controleEstoque.produto.eletronicos.Eletronicos) produto;
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
