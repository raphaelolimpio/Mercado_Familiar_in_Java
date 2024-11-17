package componentes.CaixaComponentes.caixaMercado.caixa;

import componentes.CaixaComponentes.operadorComponentes.operador.Operador;

public class Caixa {
    private int idCaixa;
    private int numerocaixa;
    private double valorCaixa;
    private Operador operador;

    public Caixa(int idCaixa, int numerocaixa, double valorCaixa) {
        this.idCaixa = idCaixa;
        this.numerocaixa = numerocaixa;
        this.valorCaixa = valorCaixa;
        this.operador = null;
    }

    public boolean estaDisponivel() {
        return operador == null;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public void atribuirOperador(Operador operador) {
        this.operador = operador;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public int getNumerocaixa() {
        return numerocaixa;
    }

    public void setNumerocaixa(int numerocaixa) {
        this.numerocaixa = numerocaixa;
    }

    public double getValorCaixa() {
        return valorCaixa;
    }

    public void setValorCaixa(double valorCaixa) {
        this.valorCaixa = valorCaixa;
    }

}
