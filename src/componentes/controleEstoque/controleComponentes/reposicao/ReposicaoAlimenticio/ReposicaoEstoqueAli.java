package componentes.controleEstoque.controleComponentes.reposicao.ReposicaoAlimenticio;

import componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios;
import componentes.controleEstoque.produtoComponentes.listaProdutosAll.ListaProdutosAll;

import java.util.List;
import java.util.Scanner;

public class ReposicaoEstoqueAli {

    private List<Alimentocios> listaAlimenticios;
    private ListaProdutosAll listaProdutosAll;

    public ReposicaoEstoqueAli(List<Alimentocios> listaAlimenticios, ListaProdutosAll listaProdutosAll) {
        this.listaAlimenticios = listaAlimenticios;
        this.listaProdutosAll = listaProdutosAll;
    }

    // Método para listar todos os produtos alimentícios
    public void listarProdutos() {
        if (listaAlimenticios.isEmpty()) {
            System.out.println("Nenhum produto alimentício disponível.");
            return;
        }

        System.out.println("Produtos Alimentícios Disponíveis:");
        for (Alimentocios produto : listaAlimenticios) {
            System.out.println("- ID: " + produto.getIdAlimenticios() +
                    ", Nome: " + produto.getNomeAlimenticios() +
                    ", Quantidade: " + produto.getQuantidadeAlimenticios());
        }
    }

    // Método para selecionar um produto por ID e adicionar quantidade
    public void atualizarQuantidade() {
        if (listaAlimenticios.isEmpty()) {
            System.out.println("Nenhum produto disponível para reposição.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        listarProdutos();
        System.out.print("Digite o ID do produto que deseja repor: ");
        String idSelecionado = scanner.nextLine();

        Alimentocios produtoSelecionado = null;
        for (Alimentocios produto : listaAlimenticios) {
            if (produto.getIdAlimenticios().equals(idSelecionado)) {
                produtoSelecionado = produto;
                break;
            }
        }

        if (produtoSelecionado == null) {
            System.out.println("Produto não encontrado com o ID fornecido.");
            return;
        }

        System.out.println("Produto selecionado: " + produtoSelecionado.getNomeAlimenticios());
        System.out.println("Quantidade atual: " + produtoSelecionado.getQuantidadeAlimenticios());

        System.out.print("Digite a quantidade a ser adicionada: ");
        int quantidadeAdicional;
        try {
            quantidadeAdicional = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Digite um número inteiro.");
            return;
        }

        if (quantidadeAdicional <= 0) {
            System.out.println("A quantidade adicional deve ser maior que zero.");
            return;
        }

        // Atualiza a quantidade no produto selecionado
        int novaQuantidade = produtoSelecionado.getQuantidadeAlimenticios() + quantidadeAdicional;
        produtoSelecionado.setQuantidadeAlimenticios(novaQuantidade);
        System.out.println("Quantidade atualizada. Nova quantidade: " + novaQuantidade);

        // Atualiza o item também na lista geral
        atualizarListaProdutosAll(produtoSelecionado);
    }

    // Método para atualizar o produto na lista geral
    private void atualizarListaProdutosAll(Alimentocios produtoAtualizado) {
        for (Object produto : listaProdutosAll.getProdutos()) {
            if (produto instanceof Alimentocios) {
                Alimentocios alimenticio = (Alimentocios) produto;
                if (alimenticio.getIdAlimenticios().equals(produtoAtualizado.getIdAlimenticios())) {
                    alimenticio.setQuantidadeAlimenticios(produtoAtualizado.getQuantidadeAlimenticios());
                    break;
                }
            }
        }
    }
}
