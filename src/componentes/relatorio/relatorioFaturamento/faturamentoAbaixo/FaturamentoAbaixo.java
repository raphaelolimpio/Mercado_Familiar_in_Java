package componentes.relatorio.relatorioFaturamento.faturamentoAbaixo;

import componentes.CaixaComponentes.caixaMercado.LucroCaixa.LucroPorCaixa.LucroPorCaixaDiario;
import componentes.CaixaComponentes.caixaMercado.caixa.Caixa;
import java.util.List;

public class FaturamentoAbaixo {

    public void gerarRelatorio(List<Caixa> listaCaixas) {
        if (listaCaixas == null || listaCaixas.isEmpty()) {
            System.out.println("Nenhum caixa disponível para gerar o relatório.");
            return;
        }

        double valorInicial = 12500.00;
        boolean encontrouAbaixo = false;

        System.out.println("Relatório de Caixas com Faturamento Abaixo do Valor Inicial");
        System.out.println("------------------------------------------------------------");

        for (Caixa caixa : listaCaixas) {
            try {
                // Verifica se o valor final do caixa é abaixo do valor inicial
                if (caixa.getValorCaixa() < valorInicial) {
                    // Cria a instância de LucroPorCaixaDiario para cada caixa
                    LucroPorCaixaDiario lucroCaixa = new LucroPorCaixaDiario(caixa);
                    lucroCaixa.calcularLucro();  // Calcula o lucro do caixa

                    // Exibe os dados do caixa
                    System.out.println("Caixa: " + caixa.getNumerocaixa());
                    System.out.println("  Valor Inicial: R$ 12.500,00");
                    System.out.println("  Valor Final: R$ " + caixa.getValorCaixa());
                    System.out.println("  Lucro do Dia: R$ " + lucroCaixa.getLucroDia());
                    System.out.println("------------------------------------------------------------");

                    encontrouAbaixo = true;
                }
            } catch (Exception e) {
                System.out.println("Erro ao processar o faturamento do caixa: " + caixa.getNumerocaixa());
            }
        }

        if (!encontrouAbaixo) {
            System.out.println("Nenhum caixa abaixo do valor inicial encontrado.");
        }
    }
}
