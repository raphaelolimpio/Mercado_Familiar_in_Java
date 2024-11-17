package sistema.caixaMercado;

import java.util.Scanner;

import componentes.controleEstoque.produtoComponentes.listaProdutosAll.ListaProdutosAll;
import componentes.controleEstoque.produtoComponentes.produto.Produto;
import componentes.vendas.ListaPrdutosCaixa.ListaProdutosCaixa;

public class CaixaMercado {
    private String nomeOperador;

    public CaixaMercado(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void iniciarVenda(ListaProdutosCaixa listaProdutosCaixa, ListaProdutosAll estoque) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digite o código do produto (ou 'fim' para finalizar): ");
            String codigoProduto = scanner.nextLine();
            if ("fim".equalsIgnoreCase(codigoProduto)) {
                break;
            }

            // Busca o produto pelo código
            Produto produto = buscarProdutoPorCodigo(codigoProduto, estoque);
            if (produto == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }

            System.out.println("Informe a quantidade do produto (por unidade ou kg): ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Consome o newline

            if (quantidade > produto.getQuantidadeProduto()) {
                System.out.println("Quantidade solicitada maior que a disponível no estoque.");
            } else {
                listaProdutosCaixa.addProdutos(produto, quantidade);
                atualizarEstoque(produto, quantidade, estoque);
            }
        }
        scanner.close();
    }

    private Produto buscarProdutoPorCodigo(String codigo, ListaProdutosAll estoque) {
        for (Produto produto : estoque.getProdutos()) {
            if (produto.getIdProduto().equals(codigo)) {
                return produto;
            }
        }
        return null;  // Produto não encontrado
    }

    private void atualizarEstoque(Produto produto, int quantidade, ListaProdutosAll estoque) {
        for (Produto p : estoque.getProdutos()) {
            if (p.getIdProduto().equals(produto.getIdProduto())) {
                p.setQuantidadeProduto(p.getQuantidadeProduto() - quantidade);
                System.out.println("Estoque atualizado para o produto " + p.getNomeProduto());
                return;
            }
        }
    }
}

