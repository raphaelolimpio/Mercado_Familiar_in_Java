package componentes.CaixaGeral.caixaMercado.caixa;

public class Caixa {
    private int idCaixa;
    private int numerocaixa;
    private double valorCaixa;


    public Caixa(int idCaixa, int numerocaixa, double valorCaixa) {
        this.idCaixa = idCaixa;
        this.numerocaixa = numerocaixa;
        this.valorCaixa = valorCaixa;
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
