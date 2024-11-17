package componentes.CaixaComponentes.operadorComponentes.removerOperador;

import java.util.List;
import java.util.Scanner;

import componentes.CaixaComponentes.operadorComponentes.operador.Operador;

public class RemoverOperador {

    private List<Operador> listaOperadores;

    public RemoverOperador(List<Operador> listaOperadores) {
        this.listaOperadores = listaOperadores;
    }

    public void removerOperador(Scanner scanner) {
        listarOperadores();

        System.out.print("Digite o ID do operador que deseja remover: ");
        int idOperador = scanner.nextInt();
        scanner.nextLine();

        Operador operador = buscarOperadorPorId(idOperador);

        if (operador != null) {

            listaOperadores.remove(operador);
            System.out.println("Operador " + operador.getNomeOperador() + " removido com sucesso.");
        } else {
            System.out.println("Operador não encontrado com o ID fornecido.");
        }
    }

    private void listarOperadores() {
        if (listaOperadores.isEmpty()) {
            System.out.println("Nenhum operador cadastrado.");
        } else {
            System.out.println("Lista de Operadores:");
            for (Operador operador : listaOperadores) {
                System.out.println("ID: " + operador.getIdOperador() + " - Nome: " + operador.getNomeOperador());
            }
        }
    }

    private Operador buscarOperadorPorId(int idOperador) {
        for (Operador operador : listaOperadores) {
            if (operador.getIdOperador() == idOperador) {
                return operador;
            }
        }
        return null;
    }
}
