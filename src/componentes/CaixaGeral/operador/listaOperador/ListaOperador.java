package componentes.CaixaGeral.operador.listaOperador;

import java.util.List;

import componentes.CaixaGeral.operador.Operador;

public class ListaOperador {
    public List<Operador> operadores;

    public ListaOperador(List<Operador> listaOperadoes) {
        this.operadores = listaOperadoes;
    }

    public void listaProdutos() {
        System.out.println("Lista de Operadores: ");
        for (Operador operador : operadores) {
            System.out.println("Operador: ");
            System.out.println("Produto Alimentício: ");
            System.out.println("Nome: " + operador.getNomeOperador());
            System.out.println("Carga Horaria: " + operador.getCargaHoraria());
            System.out.println("====================================");

        }

    }
}
