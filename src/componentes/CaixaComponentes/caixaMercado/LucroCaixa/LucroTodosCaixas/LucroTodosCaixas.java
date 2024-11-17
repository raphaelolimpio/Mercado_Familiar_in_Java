package componentes.CaixaComponentes.caixaMercado.LucroCaixa.LucroTodosCaixas;

import componentes.CaixaComponentes.caixaMercado.CofreCaixa.CofreCaixa;

public class LucroTodosCaixas {

    // Método que calcula o lucro total de todos os caixas no cofre
    public double calcularLucroTotal(CofreCaixa cofre) {
        double lucroTotal = 0.0;

        // Calculando o lucro total somando o lucro de todos os caixas
        for (Integer numeroCaixa : cofre.getCofre().keySet()) {
            lucroTotal += cofre.consultarLucroTotal(numeroCaixa);
        }

        return lucroTotal;
    }
}
