package terminal.TerminalEstoque;

import java.util.List;

import componentes.Console.Console;
import componentes.controleEstoque.produtoComponentes.produto.Produto;
import sistema.estoque.Estoque;


public class TerminalEstoque {
    
    private Estoque estoque;

    public TerminalEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    public int showMainMenu() {
        System.out.println("MENU PRINCIPAL\n\n");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Remover Produto");
        System.out.println("3 - Listar Produtos");
        System.out.println("4 - Ver Detalhes do Produto");
        System.out.println("5 - Buscar Produto");
        System.out.println("6 - Repor Estoque");
        System.out.println("7 - Sair");
        System.out.println("Escolha a sua opcao: ");
        return Console.readNumber();
    }

    public int showSearchMenu() {
        System.out.println("MENU DE BUSCA\n\n");
        System.out.println("1 - Buscar por Garantia");
        System.out.println("2 - Buscar por Setor");
        System.out.println("3 - Buscar por Validade");
        System.out.println("4 - Buscar por Unidade");
        System.out.println("5 - Voltar");
        System.out.println("Escolha a sua opção: ");
        return Console.readNumber();
    }
    

    public int showProductMenu() {
        System.out.println("MENU DO PRODUTO\n\n");
        System.out.println("1 - Editar Produto");
        System.out.println("2 - Voltar");
        System.out.println("Escolha a sua opcao: ");
        return Console.readNumber();
    }

    public int showReporEstoqueMenu() {
        System.out.println("Escolha o tipo de produto para reposição:\n");
        System.out.println("1 - Reposição de Produtos Alimentícios");
        System.out.println("2 - Reposição de Produtos Eletrônicos");
        System.out.println("3 - Voltar");
        System.out.println("Escolha a sua opção: ");
        return Console.readNumber();
    }
    
    
    public String readCustomText(String message) {
        System.out.println(message);
        return Console.readText();
    }

    public String readProductName() {
        System.out.println("Nome do produto: ");
        return Console.readText();
    }

    public float readProductPrice() {
        System.out.println("Preço do produto: ");
        return Console.readFloat();
    }

    public int readProductQuantity() {
        System.out.println("Quantidade: ");
        return Console.readNumber();
    }

    public void showProduct(Produto produto) {
        System.out.println("**********************\n");
        System.out.println("Nome: " + produto.getNomeProduto());
        System.out.println("Preço: " + produto.getValorProduto());
        System.out.println("Quantidade: " + produto.getQuantidadeProduto());
        System.out.println("**********************\n");
    }

    public void showError(String message) {
        System.out.println("Erro: " + message);
    }

    public void executarBusca() {
        int opcao = showSearchMenu();
        switch (opcao) {
            case 1:
                String garantia = readCustomText("Digite a garantia: ");
                List<Object> produtosPorGarantia = estoque.buscarPorGarantia(garantia);
                mostrarProdutos(produtosPorGarantia);
                break;

            case 2:
                String setor = readCustomText("Digite o setor: ");
                List<Object> produtosPorSetor = estoque.buscarPorSetor(setor);
                mostrarProdutos(produtosPorSetor);
                break;

            case 3:
                String validade = readCustomText("Digite a validade (AAAA-MM-DD): ");
                List<Object> produtosPorValidade = estoque.buscarPorValidade(validade);
                mostrarProdutos(produtosPorValidade);
                break;

            case 4:
                String unidade = readCustomText("Digite o nome ou ID do produto: ");
                Object produtoUnidade = estoque.buscarPorUnidade(unidade);
                if (produtoUnidade != null) {
                    System.out.println(produtoUnidade.toString());
                } else {
                    System.out.println("Produto não encontrado.");
                }
                break;

            case 5:
                System.out.println("Voltando ao menu principal...");
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    private void mostrarProdutos(List<Object> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            for (Object produto : produtos) {
                System.out.println(produto.toString());
            }
        }
    
    }

    
}
