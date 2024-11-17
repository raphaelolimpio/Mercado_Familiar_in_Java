package componentes.CaixaComponentes.caixaMercado.LucroCaixa.LucroPorCaixa;

import componentes.CaixaComponentes.caixaMercado.caixa.Caixa;

public class LucroPorCaixaDiario {
    
    private Caixa caixa;
    private double lucroDia;
    private double valorFinal;

    public LucroPorCaixaDiario(Caixa caixa) {
        this.caixa = caixa;
        this.lucroDia = 0;
        this.valorFinal = caixa.getValorCaixa();
    }
    
    public void calcularLucro() {
        // Considerando o valor inicial fixo de 12.500$
        double valorInicial = 12500.00;
        lucroDia = valorFinal - valorInicial;
    }
    
    public double getLucroDia() {
        return lucroDia;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Caixa getCaixa() {
        return caixa;
    }
}
