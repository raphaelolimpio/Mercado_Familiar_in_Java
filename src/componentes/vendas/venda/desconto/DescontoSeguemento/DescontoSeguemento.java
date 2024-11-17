package componentes.vendas.venda.desconto.DescontoSeguemento;

import componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios;
import componentes.controleEstoque.produtoComponentes.eletronicos.Eletronicos;
import componentes.vendas.ListaPrdutosCaixa.ListaProdutosCaixa;

public class DescontoSeguemento {

    private ListaProdutosCaixa listaProdutosCaixa;

    public DescontoSeguemento(ListaProdutosCaixa listaProdutosCa) {
        this.listaProdutosCaixa = listaProdutosCaixa;
    }

    public void aplicarDescontoPorTipo(String tipoProduto, double porcentagem) {
        for (Object produto : listaProdutosCaixa.getProdutos()) {
            if (tipoProduto.equalsIgnoreCase("alimenticio") && produto instanceof Alimentocios) {
                Alimentocios alimenticio = (Alimentocios) produto;
                double desconto = alimenticio.getValorAlimenticios() * (porcentagem / 100);
                alimenticio.setValorAlimenticios(alimenticio.getValorAlimenticios() - desconto);
            } else if (tipoProduto.equalsIgnoreCase("eletronico") && produto instanceof Eletronicos) {
                Eletronicos eletronico = (Eletronicos) produto;
                double desconto = eletronico.getValorEletronicos() * (porcentagem / 100);
                eletronico.setValorEletronicos(eletronico.getValorEletronicos() - desconto);
            }
        }
    }

}
