package componentes.CaixaComponentes.caixaMercado.buscarCaixa;

import java.util.List;

import componentes.CaixaComponentes.caixaMercado.caixa.Caixa;

public class BuscarCaixa {

    public List<Caixa> caixas;

    public BuscarCaixa(List<Caixa> listaCaixa) {
        this.caixas = listaCaixa;
    }

    public Caixa buscarPorNumero(int numero) {
        for (Caixa caixa : caixas) {
            if (caixa.getNumerocaixa() == numero) {
                return caixa;
            }
        }
        return null;
    }
    
}
