package componentes.CaixaComponentes.operadorComponentes.listaOperador;

import java.util.List;

import componentes.CaixaComponentes.caixaMercado.caixa.Caixa;
import componentes.CaixaComponentes.operadorComponentes.operador.Operador;

public class ListaOperador {
    public List<Operador> operadores;

    public ListaOperador(List<Operador> listaOperadoes) {
        this.operadores = listaOperadoes;
    }

    public void listaOperadores() {
        System.out.println("Lista de Operadores: ");
        for (Operador operador : operadores) {
            System.out.println("Operador: ");
            System.out.println("Nome: " + operador.getNomeOperador());
            System.out.println("Cargo: " + operador.getCargo());
            System.out.println("Carga Horária: " + operador.getCargaHoraria());
            if (operador.getCaixa() != null) {
                Caixa caixa = operador.getCaixa();
                System.out.println("Atribuído à Caixa nº " + caixa.getNumerocaixa() + " com valor: " + caixa.getValorCaixa());
            } else {
                System.out.println("Não está atribuído a nenhuma caixa.");
            }
            System.out.println("====================================");
        }
    }
}
