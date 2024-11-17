package componentes.relatorio.relatorioQuantidade;

import componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios;
import componentes.controleEstoque.produtoComponentes.eletronicos.Eletronicos;
import componentes.controleEstoque.produtoComponentes.listaProdutosAll.ListaProdutosAll;

public class RelatorioQuantidade {

    public void gerarRelatorio(ListaProdutosAll listaProdutosAll) {
        if (listaProdutosAll == null || listaProdutosAll.getProdutos().isEmpty()) {
            System.out.println("Nenhum produto disponível para gerar o relatório.");
            return;
        }

        System.out.println("Relatório de Quantidade - Produtos com Estoque <= 5");
        System.out.println("---------------------------------------------------");

        boolean encontrouProdutos = false;

        for (Object produto : listaProdutosAll.getProdutos()) {
            if (produto instanceof Alimentocios) {
                Alimentocios alimenticio = (Alimentocios) produto;
                if (alimenticio.getQuantidadeAlimenticios() <= 5) {
                    System.out.println("Produto Alimentício: " + alimenticio.getNomeAlimenticios());
                    System.out.println("  Setor: " + alimenticio.getSetor());
                    System.out.println("  Quantidade: " + alimenticio.getQuantidadeAlimenticios());
                    System.out.println("---------------------------------------------------");
                    encontrouProdutos = true;
                }
            } else if (produto instanceof Eletronicos) {
                Eletronicos eletronico = (Eletronicos) produto;
                if (eletronico.getQuantidadeEletronicos() <= 5) {
                    System.out.println("Produto Eletrônico: " + eletronico.getNomeEletronicos());
                    System.out.println("  Marca: " + eletronico.getMarcaEletronicos());
                    System.out.println("  Setor: " + eletronico.getSetor());
                    System.out.println("  Quantidade: " + eletronico.getQuantidadeEletronicos());
                    System.out.println("---------------------------------------------------");
                    encontrouProdutos = true;
                }
            }
        }

        if (!encontrouProdutos) {
            System.out.println("Nenhum produto com quantidade menor ou igual a 5 foi encontrado.");
        }
    }
}
