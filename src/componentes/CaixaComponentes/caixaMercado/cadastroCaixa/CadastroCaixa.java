package componentes.CaixaComponentes.caixaMercado.cadastroCaixa;

import java.util.ArrayList;
import java.util.List;

import componentes.CaixaComponentes.caixaMercado.caixa.Caixa;

public class CadastroCaixa {

    private List<Caixa> listcaCaixa;

    public CadastroCaixa() {
        listcaCaixa = new ArrayList<>();
    }

    public void adicionarCaixa(Caixa caixa) {
        listcaCaixa.add(caixa);
        System.out.println("Produto alimentício adicionado: " + caixa.getNumerocaixa());
    }

    public List<Caixa> getListaCaixa() {
        return listcaCaixa;
    }

}
