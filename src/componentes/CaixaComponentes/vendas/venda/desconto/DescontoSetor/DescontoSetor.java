package componentes.CaixaComponentes.vendas.venda.desconto.DescontoSetor;

import componentes.CaixaComponentes.vendas.ListaPrdutosCaixa.ListaProdutosCaixa;
import componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios;
import componentes.controleEstoque.produtoComponentes.eletronicos.Eletronicos;

public class DescontoSetor {

    private ListaProdutosCaixa listaProdutosCaixa;

    public DescontoSetor(ListaProdutosCaixa listaProdutosCa) {
        this.listaProdutosCaixa = listaProdutosCaixa;
    }

    public void aplicarDescontoPorSetor(String setor, double porcentagem) {
        for (Object produto : listaProdutosCaixa.getProdutos()) {
            if (produto instanceof Alimentocios && ((Alimentocios) produto).getSetor().equalsIgnoreCase(setor)) {
                Alimentocios alimenticio = (Alimentocios) produto;
                double desconto = alimenticio.getValorAlimenticios() * (porcentagem / 100);
                alimenticio.setValorAlimenticios(alimenticio.getValorAlimenticios() - desconto);
            } else if (produto instanceof Eletronicos && ((Eletronicos) produto).getSetor().equalsIgnoreCase(setor)) {
                Eletronicos eletronico = (Eletronicos) produto;
                double desconto = eletronico.getValorEletronicos() * (porcentagem / 100);
                eletronico.setValorEletronicos(eletronico.getValorEletronicos() - desconto);
            }
        }
    }

}
