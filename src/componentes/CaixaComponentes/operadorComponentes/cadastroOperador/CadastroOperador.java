package componentes.CaixaComponentes.operadorComponentes.cadastroOperador;

import java.util.ArrayList;
import java.util.List;

import componentes.CaixaComponentes.caixaMercado.caixa.Caixa;
import componentes.CaixaComponentes.operadorComponentes.operador.Operador;

public class CadastroOperador {
    private List<Operador> listaOperador;

    public CadastroOperador() {
        listaOperador = new ArrayList<>();
    }

    public void adicionarOperador(Operador operador) {
        listaOperador.add(operador);
        System.out.println("Produto alimentício adicionado: " + operador.getNomeOperador());
    }

    public void adicionarCaixaOperador(Operador operador, Caixa caixa) {
        operador.setCaixa(caixa);
        System.out.println("Operador " + operador.getNomeOperador() + " atribuído à Caixa nº " + caixa.getNumerocaixa());

    }

    public List<Operador> getListaOperador() {
        return listaOperador;
    }
}
