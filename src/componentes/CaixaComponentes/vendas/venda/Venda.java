package componentes.CaixaComponentes.vendas.venda;

import componentes.CaixaComponentes.vendas.ListaPrdutosCaixa.ListaProdutosCaixa;
import componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios;
import componentes.controleEstoque.produtoComponentes.eletronicos.Eletronicos;

public class Venda {

    private ListaProdutosCaixa listaProdutosCaixa;

    public Venda(ListaProdutosCaixa listaProdutosCa) {
        this.listaProdutosCaixa = listaProdutosCaixa;
    }

    public double calcularTotal() {
        double total = 0;
        for (Object produto : listaProdutosCaixa.getProdutos()) {
            if (produto instanceof Alimentocios) {
                total += ((Alimentocios) produto).getValorAlimenticios();
            } else if (produto instanceof Eletronicos) {
                total += ((Eletronicos) produto).getValorEletronicos();
            }
        }
        return total;
    }

    public void exibirDetalhesVenda() {
        System.out.println("Detalhes da Venda:");
        for (Object produto : listaProdutosCaixa.getProdutos()) {
            if (produto instanceof Alimentocios) {
                Alimentocios alimenticio = (Alimentocios) produto;
                System.out.printf("Alimentício: %s - Valor: %.2f\n", alimenticio.getNomeAlimenticios(),
                        alimenticio.getValorAlimenticios());
            } else if (produto instanceof Eletronicos) {
                Eletronicos eletronico = (Eletronicos) produto;
                System.out.printf("Eletrônico: %s - Valor: %.2f\n", eletronico.getNomeEletronicos(),
                        eletronico.getValorEletronicos());
            }
        }
        System.out.printf("Total da Venda: %.2f\n", calcularTotal());
    }

}
