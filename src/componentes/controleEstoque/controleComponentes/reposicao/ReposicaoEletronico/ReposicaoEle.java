package componentes.controleEstoque.controleComponentes.reposicao.ReposicaoEletronico;

import componentes.controleEstoque.produtoComponentes.eletronicos.Eletronicos;
import componentes.controleEstoque.produtoComponentes.listaProdutosAll.ListaProdutosAll;

import java.util.List;
import java.util.Scanner;

public class ReposicaoEle {

    private List<Eletronicos> listaEletronicos;
    private ListaProdutosAll listaProdutosAll;

    public ReposicaoEle(List<Eletronicos> listaEletronicos, ListaProdutosAll listaProdutosAll) {
        this.listaEletronicos = listaEletronicos;
        this.listaProdutosAll = listaProdutosAll;
    }

    // Método para listar todos os produtos eletrônicos
    public void listarProdutos() {
        if (listaEletronicos.isEmpty()) {
            System.out.println("Nenhum produto eletrônico disponível.");
            return;
        }

        System.out.println("Produtos Eletrônicos Disponíveis:");
        for (Eletronicos produto : listaEletronicos) {
            System.out.println("- ID: " + produto.getIdProduto() +
                    ", Nome: " + produto.getNomeEletronicos() +
                    ", Quantidade: " + produto.getQuantidadeEletronicos());
        }
    }

    // Método para selecionar um produto por ID e adicionar quantidade
    @SuppressWarnings("unlikely-arg-type")
    public void atualizarQuantidade() {
        if (listaEletronicos.isEmpty()) {
            System.out.println("Nenhum produto disponível para reposição.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        listarProdutos();
        System.out.print("Digite o ID do produto que deseja repor: ");
        int idSelecionado = scanner.nextInt();

        Eletronicos produtoSelecionado = null;
        for (Eletronicos produto : listaEletronicos) {
            if (produto.getIdProduto().equals(idSelecionado)) {
                produtoSelecionado = produto;
                break;
            }
        }

        if (produtoSelecionado == null) {
            System.out.println("Produto não encontrado com o ID fornecido.");
            return;
        }

        System.out.println("Produto selecionado: " + produtoSelecionado.getNomeEletronicos());
        System.out.println("Quantidade atual: " + produtoSelecionado.getQuantidadeEletronicos());

        System.out.print("Digite a quantidade a ser adicionada: ");
        int quantidadeAdicional = scanner.nextInt();

        if (quantidadeAdicional <= 0) {
            System.out.println("A quantidade adicional deve ser maior que zero.");
            return;
        }

        // Atualiza a quantidade no produto selecionado
        int novaQuantidade = produtoSelecionado.getQuantidadeEletronicos() + quantidadeAdicional;
        produtoSelecionado.setQuantidadeEletronicos(novaQuantidade);
        System.out.println("Quantidade atualizada. Nova quantidade: " + novaQuantidade);

        // Atualiza o item também na lista geral
        atualizarListaProdutosAll(produtoSelecionado);
    }

    // Método para atualizar o produto na lista geral
    private void atualizarListaProdutosAll(Eletronicos produtoAtualizado) {
        for (Object produto : listaProdutosAll.getProdutos()) {
            if (produto instanceof Eletronicos) {
                Eletronicos eletronico = (Eletronicos) produto;
                if (eletronico.getIdProduto() == produtoAtualizado.getIdProduto()) {
                    eletronico.setQuantidadeEletronicos(produtoAtualizado.getQuantidadeEletronicos());
                    break;
                }
            }
        }
    }
}
