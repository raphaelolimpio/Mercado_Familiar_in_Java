package componentes.relatorio.relatorioFaturamento.FaturamentoDiario;


import componentes.CaixaComponentes.caixaMercado.LucroCaixa.LucroPorCaixa.LucroPorCaixaDiario;
import componentes.CaixaComponentes.caixaMercado.caixa.Caixa;
import java.util.List;

public class FaturamentoDiario {

    public void gerarRelatorio(List<Caixa> listaCaixas) {
        if (listaCaixas == null || listaCaixas.isEmpty()) {
            System.out.println("Nenhum caixa disponível para gerar o relatório.");
            return;
        }

        double totalLucro = 0.0;
        System.out.println("Relatório de Faturamento Diário Total");
        System.out.println("---------------------------------------------------");

        boolean encontrouCaixas = false;
        for (Caixa caixa : listaCaixas) {
            try {
                // Cria a instância de LucroPorCaixaDiario para cada caixa
                LucroPorCaixaDiario lucroCaixa = new LucroPorCaixaDiario(caixa);
                
                // Calcula o lucro diário do caixa
                lucroCaixa.calcularLucro();
                
                // Soma o lucro diário ao total
                totalLucro += lucroCaixa.getLucroDia();
                
                // Exibe os dados do caixa e seu lucro diário
                System.out.println("Caixa: " + caixa.getNumerocaixa());
                System.out.println("  Valor Inicial: R$ 12.500,00");
                System.out.println(" Operador: " + caixa.getOperador());
                System.out.println("  Valor Final: R$ " + caixa.getValorCaixa());
                System.out.println("  Lucro do Dia: R$ " + lucroCaixa.getLucroDia());
                System.out.println("---------------------------------------------------");

                encontrouCaixas = true;
            } catch (Exception e) {
                System.out.println("Erro ao processar o faturamento do caixa: " + caixa.getNumerocaixa());
            }
        }

        if (!encontrouCaixas) {
            System.out.println("Nenhum caixa com faturamento diário encontrado.");
        }

        // Exibe o faturamento total
        System.out.println("Faturamento Total do Dia: R$ " + totalLucro);
    }
}
