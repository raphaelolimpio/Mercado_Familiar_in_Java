package componentes.relatorio.relatorioQualidade;

import componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;



public class RelatorioQualidade {

    private static final int DIAS_PROXIMOS = 20;

    public void gerarRelatorio(List<Alimentocios> listaAlimenticios) {
        if (listaAlimenticios == null || listaAlimenticios.isEmpty()) {
            System.out.println("Nenhum produto alimentício disponível para gerar o relatório.");
            return;
        }

        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        System.out.println("Relatório de Qualidade - Produtos Próximos da Validade (20 dias)");
        System.out.println("Data Atual: " + dataAtual.format(formatter));
        System.out.println("---------------------------------------------------");

        boolean encontrouProximos = false;
        for (Alimentocios alimenticio : listaAlimenticios) {
            try {
                LocalDate validade = LocalDate.parse(alimenticio.getValidadeAlimenticios(), formatter);
                long diferencaDias = ChronoUnit.DAYS.between(dataAtual, validade);

                if (diferencaDias >= 0 && diferencaDias <= DIAS_PROXIMOS) {
                    System.out.println("Produto: " + alimenticio.getNomeAlimenticios());
                    System.out.println("  Setor: " + alimenticio.getSetor());
                    System.out.print("Quantidade: " + alimenticio.getQuantidadeAlimenticios());
                    System.out.println("  Validade: " + validade.format(formatter));
                    System.out.println("  Dias para vencer: " + diferencaDias);
                    System.out.println("---------------------------------------------------");
                    encontrouProximos = true;
                }
            } catch (Exception e) {
                System.out.println("Erro ao processar validade do produto: " + alimenticio.getNomeAlimenticios());
            }
        }

        if (!encontrouProximos) {
            System.out.println("Nenhum produto com validade próxima encontrado.");
        }
    }
}
