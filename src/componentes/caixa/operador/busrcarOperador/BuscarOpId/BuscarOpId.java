package componentes.caixa.operador.busrcarOperador.BuscarOpId;

import java.util.List;

import componentes.caixa.operador.Operador;

public class BuscarOpId {

        private List<Operador> operadores;

    // Construtor que recebe a lista de operadores
    public BuscarOpId(List<Operador> listaOperadores) {
        this.operadores = listaOperadores;
    }

    public Operador buscarPorId(int id) {
        for (Operador operador : operadores) {
            if (operador.getIdOperador() == id) {
                return operador;
            }
        }
        return null;
    }
    
}
