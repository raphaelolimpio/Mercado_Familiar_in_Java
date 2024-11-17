package terminal.TerminalCaixa;

import java.util.List;
import sistema.caixaMercado.CaixaMercado;

public class TerminalCaixa {

    public void listarCaixas(List<CaixaMercado> caixas) {
        for (int i = 0; i < caixas.size(); i++) {
            System.out.println("Caixa " + (i + 1) + ": " + caixas.get(i).getNomeOperador());
        }
    }

    public CaixaMercado selecionarCaixa(List<CaixaMercado> caixas, int caixaSelecionado) {
        return caixas.get(caixaSelecionado - 1);
    }
}
