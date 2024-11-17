package componentes.CaixaGeral.operador.cadastroOperador;

import java.util.ArrayList;
import java.util.List;

import componentes.CaixaGeral.operador.Operador;

public class CadastroOperador {
    private List<Operador> listaOperador;

    public CadastroOperador() {
        listaOperador = new ArrayList<>();
    }

    public void adicionarOperador(Operador operador) {
        listaOperador.add(operador);
        System.out.println("Produto alimentício adicionado: " + operador.getNomeOperador());
    }

    public List<Operador> getListaOperador() {
        return listaOperador;
    }
}
