package terminal.TerminalAdm;

import sistema.administrativo.Administrativo;
import componentes.CaixaComponentes.caixaMercado.cadastroCaixa.CadastroCaixa;
import componentes.CaixaComponentes.caixaMercado.caixa.Caixa;
import componentes.CaixaComponentes.operadorComponentes.buscarOperador.buscarOperador.BuscarOpNome.BuscarOpNome;
import componentes.CaixaComponentes.operadorComponentes.buscarOperador.busrcarOperador.BuscarOpId.BuscarOpId;
import componentes.CaixaComponentes.operadorComponentes.operador.Operador;
import java.util.List;
import java.util.Scanner;

public class TerminalAdm {
    private Administrativo administrativo;
    private CadastroCaixa cadastroCaixa;

    public TerminalAdm() {
        this.administrativo = new Administrativo();
    }

    public void exibirMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Menu Principal ADM ===");
            System.out.println("1. Relatório");
            System.out.println("2. Operador");
            System.out.println("3. Caixa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    exibirMenuRelatorios(scanner);
                    break;
                case 2:
                    exibirMenuOperadores(scanner);
                    break;
                case 3:
                    exibirMenuCaixa(scanner);
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        } while (opcao != 0);
        scanner.close();
    }

    private void exibirMenuRelatorios(Scanner scanner) {
        System.out.println("=== Relatórios ===");
        System.out.println("1. Relatório de Qualidade (Produtos Próximos da Validade)");
        System.out.println("2. Relatório de Quantidade (Estoque <= 5)");
        System.out.println("3. Relatório de Faturamento Diario");
        System.out.println("4. Relatório de Faturamento Abaixo");
        System.out.print("Escolha uma opção: ");
        int opcaoRelatorio = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoRelatorio) {
            case 1:
                System.out.println("Gerando Relatório de Qualidade...");
                administrativo.gerarRelatorioQualidade();
                break;
            case 2:
                System.out.println("Gerando Relatório de Quantidade...");
                administrativo.gerarRelatorioQuantidade();
                break;
            case 3:
                System.out.println("Gerando Relatório de Faturamento Diario...");
                administrativo.gerarRelatorioFaturamentoDiario();
                break;
            case 4:
                System.out.println("Gerando Relatório de Faturamento Abaixo...");
                administrativo.gerarRelatorioFaturamentoAbaixo();
                break;
            default:
                System.out.println("Opção inválida. Voltando ao menu principal.");
        }
    }

    private void exibirMenuOperadores(Scanner scanner) {
        System.out.println("=== Operadores ===");
        System.out.println("1. Cadastrar Novo Operador");
        System.out.println("2. Buscar Operador");
        System.out.println("3. Listar Operadores");
        System.out.println("4. Deletar Operador");
        System.out.print("Escolha uma opção: ");
        int opcaoOperador = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoOperador) {
            case 1:
                cadastrarOperador(scanner);
                break;
            case 2:
                buscarOperador(scanner);
                break;
            case 3:
                listaOperador(scanner);
                break;
            case 4:
                deletarOperador(scanner);
                break;
            default:
                System.out.println("Opção inválida. Voltando ao menu principal.");
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
    
    
        List<Caixa> caixasDisponiveis = cadastroCaixa.getListaCaixa().stream()
                .filter(Caixa::estaDisponivel)
                .toList();
    
        if (caixasDisponiveis.isEmpty()) {
            System.out.println("Não há caixas disponíveis para atribuir.");
        } else {
            System.out.println("Selecione uma caixa para atribuir o operador:");
            for (int i = 0; i < caixasDisponiveis.size(); i++) {
                Caixa caixa = caixasDisponiveis.get(i);
                System.out.println((i + 1) + ". Caixa nº " + caixa.getNumerocaixa() + " (Valor no caixa: " + caixa.getValorCaixa() + ")");
            }
    
            int escolha = scanner.nextInt();
            scanner.nextLine();
    
            if (escolha > 0 && escolha <= caixasDisponiveis.size()) {
                Caixa caixaSelecionada = caixasDisponiveis.get(escolha - 1);
                Operador operador = administrativo.getListaOperador().get(administrativo.getListaOperador().size() - 1); // Último operador adicionado
                caixaSelecionada.atribuirOperador(operador);
                System.out.println("Operador " + operador.getNomeOperador() + " atribuído à Caixa nº " + caixaSelecionada.getNumerocaixa());
            } else {
                System.out.println("Escolha inválida.");
            }
        }
    }
    

    private void exibirMenuCaixa(Scanner scanner) {
        System.out.println("=== Menu Caixa ===");
        System.out.println("1. Criar Caixa");
        System.out.println("2. Buscar Caixa");
        System.out.println("3. Listar Caixas");
        System.out.print("Escolha uma opção: ");
        int opcaoCaixa = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoCaixa) {
            case 1:
                criarCaixa(scanner);
                break;
            case 2:
                buscarCaixa(scanner);
                break;
            case 3:
                listarCaixas();
                break;
            default:
                System.out.println("Opção inválida. Voltando ao menu principal.");
        }
    }

    private void criarCaixa(Scanner scanner) {
        System.out.println("=== Criar Caixa ===");
        System.out.print("Digite o número do caixa: ");
        int numeroCaixa = scanner.nextInt();
        System.out.print("Digite o valor do caixa: ");
        double valorCaixa = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        Caixa caixa = new Caixa(0, numeroCaixa, valorCaixa); // ID é gerado automaticamente
        administrativo.cadastrarCaixa(caixa);
    }

    private void buscarCaixa(Scanner scanner) {
        System.out.println("=== Buscar Caixa ===");
        System.out.print("Digite o número do caixa: ");
        int numeroCaixa = scanner.nextInt();
        scanner.nextLine();

        Caixa caixa = administrativo.buscarCaixa(numeroCaixa);
        if (caixa != null) {
            System.out.println("Caixa encontrado:");
            System.out.println("Número: " + caixa.getNumerocaixa());
            System.out.println("Valor: " + caixa.getValorCaixa());
        } else {
            System.out.println("Caixa não encontrado.");
        }
    }

    private void listarCaixas() {
        System.out.println("=== Listar Caixas ===");
        List<Caixa> caixas = administrativo.obterListaCaixas();
        if (caixas.isEmpty()) {
            System.out.println("Nenhum caixa cadastrado.");
        } else {
            for (Caixa caixa : caixas) {
                System.out.println("Número: " + caixa.getNumerocaixa());
                System.out.println("Valor: " + caixa.getValorCaixa());
                System.out.println("====================================");
            }
        }
    }

    private void buscarOperador(Scanner scanner) {
        System.out.println("=== Buscar Operador ===");
        System.out.println("Escolha o tipo de pesquisa:");
        System.out.println("1. Buscar por Nome");
        System.out.println("2. Buscar por ID");
        System.out.print("Escolha uma opção: ");
        int opcaoBusca = scanner.nextInt();
        scanner.nextLine();

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

    private void listaOperador(Scanner scanner) {
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

    private void deletarOperador(Scanner scanner) {
        System.out.println("=== Deletar Operador ===");
        administrativo.removerOperador(scanner);

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
}
