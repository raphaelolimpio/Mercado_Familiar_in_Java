package componentes.caixa.operador.busrcarOperador.BuscarOpId.BuscarOpNome;

import java.util.List;

import componentes.caixa.operador.Operador;

public class BuscarOpNome {
    private List<Operador> operadores;

    // Construtor que recebe a lista de operadores
    public BuscarOpNome(List<Operador> listaOperadores) {
        this.operadores = listaOperadores;
    }
    public Operador buscarPorNome(String nome) {
        for (Operador operador : operadores) {
            if (operador.getNomeOperador().equalsIgnoreCase(nome)) {
                return operador;
            }
        }
        return null; 
    }
}
