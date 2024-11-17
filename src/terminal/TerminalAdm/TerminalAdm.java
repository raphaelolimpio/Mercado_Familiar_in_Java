package terminal.TerminalAdm;

import sistema.administrativo.Administrativo;

import java.util.List;
import java.util.Scanner;

import componentes.CaixaComponentes.operadorComponentes.buscarOperador.buscarOperador.BuscarOpNome.BuscarOpNome;
import componentes.CaixaComponentes.operadorComponentes.buscarOperador.busrcarOperador.BuscarOpId.BuscarOpId;
import componentes.CaixaComponentes.operadorComponentes.operador.Operador;

public class TerminalAdm {
    private Administrativo administrativo;

    public TerminalAdm() {
        this.administrativo = new Administrativo();
    }

    public void exibirMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Menu Administrativo ===");
            System.out.println("1. Gerar Relatório de Qualidade");
            System.out.println("2. Gerar Relatório de Quantidade");
            System.out.println("3. Cadastrar Novo Operador");
            System.out.println("4. Buscar Operador");
            System.out.println("5. Listar Operador");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("1. Relatório de Qualidade (Produtos Próximos da Validade)");
                    administrativo.gerarRelatorioQualidade();
                    break;
                case 2:
                    System.out.println("2. Relatório de Quantidade (Estoque <= 5)");
                    administrativo.gerarRelatorioQuantidade();
                    break;
                case 3:
                    cadastrarOperador(scanner);
                    break;
                case 4:
                    buscarOperador(scanner);
                    break;
                case 5: 
                    listaOperador(scanner);
                case 0:
                    System.out.println("Saindo do menu de relatórios...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        } while (opcao != 0);
        scanner.close();
    }

    private void buscarOperador(Scanner scanner) {
        System.out.println("=== Buscar Operador ===");
        System.out.println("Escolha o tipo de pesquisa:");
        System.out.println("1. Buscar por Nome");
        System.out.println("2. Buscar por ID");
        System.out.print("Escolha uma opção: ");
        int opcaoBusca = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        List<Operador> listaOperadores = administrativo.obterListaOperadores();

        if (opcaoBusca == 1) {
            System.out.print("Digite o nome do operador: ");
            String nome = scanner.nextLine();
            BuscarOpNome buscarPorNome = new BuscarOpNome(listaOperadores);
            Operador operador = buscarPorNome.buscarPorNome(nome);
            exibirResultadoBusca(operador);
        } else if (opcaoBusca == 2) {
            System.out.print("Digite o ID do operador: ");
            int id = scanner.nextInt();
            BuscarOpId buscarPorId = new BuscarOpId(listaOperadores);
            Operador operador = buscarPorId.buscarPorId(id);
            exibirResultadoBusca(operador);
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void exibirResultadoBusca(Operador operador) {
        if (operador != null) {
            System.out.println("Operador encontrado: ");
            System.out.println("Nome: " + operador.getNomeOperador());
            System.out.println("Cargo: " + operador.getCargo());
            System.out.println("Carga Horária: " + operador.getCargaHoraria());
        } else {
            System.out.println("Operador não encontrado.");
        }
    }

    private void cadastrarOperador(Scanner scanner) {

        System.out.println("=== Cadastro de Novo Operador ===");
        System.out.print("Digite o nome do operador: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cargo do operador: ");
        String cargo = scanner.nextLine();
        System.out.print("Digite a carga horária do operador: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine(); 
        administrativo.adicionarOperador(nome, cargo, cargaHoraria);
        System.out.println("Operador cadastrado com sucesso!");
    }

    private void listaOperador(Scanner scanner) {
        // Chama o método obterListaOperadores para obter a lista
        List<Operador> listaOperadores = administrativo.obterListaOperadores();

        // Exibe a lista de operadores
        if (listaOperadores.isEmpty()) {
            System.out.println("Nenhum operador cadastrado.");
        } else {
            System.out.println("=== Lista de Operadores ===");
            for (Operador operador : listaOperadores) {
                System.out.println("ID: " + operador.getIdOperador());
                System.out.println("Nome: " + operador.getNomeOperador());
                System.out.println("Cargo: " + operador.getCargo());
                System.out.println("Carga Horária: " + operador.getCargaHoraria());
                System.out.println("-----------------------------------");
            }
        }
    }
    


}
