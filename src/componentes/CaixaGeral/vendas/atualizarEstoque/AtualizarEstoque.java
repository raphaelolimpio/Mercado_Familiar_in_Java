package componentes.CaixaGeral.vendas.atualizarEstoque;

import componentes.CaixaGeral.vendas.ListaPrdutosCaixa.ListaProdutosCaixa;
import componentes.controleEstoque.produto.alimenticios.Alimentocios;
import componentes.controleEstoque.produto.eletronicos.Eletronicos;
import componentes.controleEstoque.produto.listaProdutosAll.ListaProdutosAll;


public class AtualizarEstoque {

    private ListaProdutosAll estoque;

    public AtualizarEstoque(ListaProdutosAll estoque) {
        this.estoque = estoque;
    }

    public void atualizarEstoque(ListaProdutosCaixa produtosCaixa) {
        for (Object produtoCaixa : produtosCaixa.getProdutos()) {
            if (produtoCaixa instanceof Alimentocios) {
                Alimentocios alimenticioCaixa = (Alimentocios) produtoCaixa;
                atualizarAlimenticio(alimenticioCaixa);
            } else if (produtoCaixa instanceof Eletronicos) {
                Eletronicos eletronicoCaixa = (Eletronicos) produtoCaixa;
                atualizarEletronico(eletronicoCaixa);
            } else {
                System.out.println("Tipo de produto desconhecido: " + produtoCaixa);
            }
        }
    }

    private void atualizarAlimenticio(Alimentocios alimenticioCaixa) {
        for (Object produtoEstoque : estoque.getProdutos()) {
            if (produtoEstoque instanceof Alimentocios) {
                Alimentocios alimenticioEstoque = (Alimentocios) produtoEstoque;
                if (alimenticioEstoque.getIdAlimenticios() == alimenticioCaixa.getIdAlimenticios()) {
                    int novaQuantidade = alimenticioEstoque.getQuantidadeAlimenticios() - alimenticioCaixa.getQuantidadeAlimenticios();
                    if (novaQuantidade < 0) {
                        System.out.println("Quantidade insuficiente para o produto: " + alimenticioEstoque.getNomeAlimenticios());
                    } else {
                        alimenticioEstoque.setQuantidadeAlimenticios(novaQuantidade);
                        System.out.println("Atualizado: " + alimenticioEstoque.getNomeAlimenticios() + " - Nova quantidade: " + novaQuantidade);
                    }
                    return;
                }
            }
        }
        System.out.println("Produto alimentício não encontrado no estoque: " + alimenticioCaixa.getNomeAlimenticios());
    }

    private void atualizarEletronico(Eletronicos eletronicoCaixa) {
        for (Object produtoEstoque : estoque.getProdutos()) {
            if (produtoEstoque instanceof Eletronicos) {
                Eletronicos eletronicoEstoque = (Eletronicos) produtoEstoque;
                if (eletronicoEstoque.getIdEletronicos() == eletronicoCaixa.getIdEletronicos()) {
                    int novaQuantidade = eletronicoEstoque.getQuantidadeEletronicos() - eletronicoCaixa.getQuantidadeEletronicos();
                    if (novaQuantidade < 0) {
                        System.out.println("Quantidade insuficiente para o produto: " + eletronicoEstoque.getNomeEletronicos());
                    } else {
                        eletronicoEstoque.setQuantidadeEletronicos(novaQuantidade);
                        System.out.println("Atualizado: " + eletronicoEstoque.getNomeEletronicos() + " - Nova quantidade: " + novaQuantidade);
                    }
                    return;
                }
            }
        }
        System.out.println("Produto eletrônico não encontrado no estoque: " + eletronicoCaixa.getNomeEletronicos());
    }
}
