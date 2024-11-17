package componentes.controleEstoque.controle.editarEstoque;

import java.util.List;
import java.util.Scanner;

import componentes.controleEstoque.produto.alimenticios.Alimentocios;
import componentes.controleEstoque.produto.eletronicos.Eletronicos;

public class EditarEstoque {

    private Scanner scanner;

    public EditarEstoque() {
        this.scanner = new Scanner(System.in);
    }

    // Método para editar um produto alimentício
    private void editarAlimenticio(Alimentocios alimenticio) {
        System.out.println("Editar Produto Alimentício: " + alimenticio.getNomeAlimenticios());
        System.out.println("Selecione o campo para editar:");
        System.out.println("1. Nome");
        System.out.println("2. Setor");
        System.out.println("3. Valor");
        System.out.println("4. Validade");
        System.out.println("5. Quantidade");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        switch (escolha) {
            case 1:
                System.out.print("Novo Nome: ");
                alimenticio.setNomeAlimenticios(scanner.nextLine());
                break;
            case 2:
                System.out.print("Novo Setor: ");
                alimenticio.setSetor(scanner.nextLine());
                break;
            case 3:
                System.out.print("Novo Valor: ");
                alimenticio.setValorAlimenticios(scanner.nextDouble());
                scanner.nextLine();
                break;
            case 4:
                System.out.print("Nova Validade: ");
                alimenticio.setValidadeAlimenticios(scanner.nextLine());
                break;
            case 5:
                System.out.print("Nova Quantidade: ");
                alimenticio.setQuantidadeAlimenticios(scanner.nextInt());
                scanner.nextLine();
                break;
            default:
                System.out.println("Opção inválida.");
        }

        System.out.println("Produto atualizado: " + alimenticio.getNomeAlimenticios());
    }

    // Método para editar um produto eletrônico
    private void editarEletronico(Eletronicos eletronico) {
        System.out.println("Editar Produto Eletrônico: " + eletronico.getNomeEletronicos());
        System.out.println("Selecione o campo para editar:");
        System.out.println("1. Nome");
        System.out.println("2. Setor");
        System.out.println("3. Valor");
        System.out.println("4. Garantia");
        System.out.println("5. Quantidade");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        switch (escolha) {
            case 1:
                System.out.print("Novo Nome: ");
                eletronico.setNomeEletronicos(scanner.nextLine());
                break;
            case 2:
                System.out.print("Novo Setor: ");
                eletronico.setSetor(scanner.nextLine());
                break;
            case 3:
                System.out.print("Novo Valor: ");
                eletronico.setValorEletronicos(scanner.nextDouble());
                scanner.nextLine();
                break;
            case 4:
                System.out.print("Nova Garantia: ");
                eletronico.setGarantiaEletronicos(scanner.nextLine());
                break;
            case 5:
                System.out.print("Nova Quantidade: ");
                eletronico.setQuantidadeEletronicos(scanner.nextInt());
                scanner.nextLine();
                break;
            default:
                System.out.println("Opção inválida.");
        }

        System.out.println("Produto atualizado: " + eletronico.getNomeEletronicos());
    }

    // Método para selecionar um produto para edição
    public void selecionarItemParaEditar(List<Object> produtos) {
        System.out.println("Selecione o item para editar:");
        for (int i = 0; i < produtos.size(); i++) {
            Object produto = produtos.get(i);
            if (produto instanceof Alimentocios) {
                System.out.println((i + 1) + ". Alimentício: " + ((Alimentocios) produto).getNomeAlimenticios());
            } else if (produto instanceof Eletronicos) {
                System.out.println((i + 1) + ". Eletrônico: " + ((Eletronicos) produto).getNomeEletronicos());
            }
        }

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        if (escolha < 1 || escolha > produtos.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Object produtoSelecionado = produtos.get(escolha - 1);
        if (produtoSelecionado instanceof Alimentocios) {
            editarAlimenticio((Alimentocios) produtoSelecionado);
        } else if (produtoSelecionado instanceof Eletronicos) {
            editarEletronico((Eletronicos) produtoSelecionado);
        } else {
            System.out.println("Tipo de produto desconhecido.");
        }
    }
}
