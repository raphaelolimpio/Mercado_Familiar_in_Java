package componentes.CaixaGeral.caixaMercado.listacaixa;

import java.util.List;

import componentes.CaixaGeral.caixaMercado.caixa.Caixa;

public class ListaCaixa {
    public List<Caixa> caixas;

    public ListaCaixa(List<Caixa> listaCaixa) {
        this.caixas = listaCaixa;
    }

    public void listaProdutos() {
        System.out.println("Lista de Operadores: ");
        for (Caixa caixa : caixas) {
            System.out.println("Caixa: ");
            System.out.println("Número: " + caixa.getNumerocaixa());
            System.out.println("Valor no caixa: " + caixa.getValorCaixa());
            System.out.println("====================================");
        }
    }
    
}
