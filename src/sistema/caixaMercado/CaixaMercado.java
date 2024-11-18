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

            Produto produto = buscarProdutoNoEstoque(codigoProduto, estoque);  // Renomeado para evitar duplicação
            
            if (produto == null) {
                System.out.println("Erro: Produto com código " + codigoProduto + " não encontrado.");
                continue;  
            }

            System.out.println("Informe a quantidade do produto (por unidade ou kg): ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 
            if (quantidade > produto.getQuantidadeProduto()) {
                System.out.println("Erro: Quantidade solicitada (" + quantidade + ") maior que a disponível no estoque (" + produto.getQuantidadeProduto() + ").");
                continue;  
            } else {
                listaProdutosCaixa.addProdutos(produto, quantidade);
                atualizarEstoqueRemovido(produto, quantidade, estoque);
                System.out.println("Produto adicionado: " + produto.getNomeProduto() + " - Quantidade: " + quantidade);
            }
        }
    
        scanner.close();
    }

    // Método para buscar no estoque (ListaProdutosAll)
    private Produto buscarProdutoNoEstoque(String codigo, ListaProdutosAll estoque) {
        for (Produto produto : estoque.getProdutos()) {
            if (produto.getIdProduto().equals(codigo)) {
                return produto;
            }
        }
        return null;  // Produto não encontrado no estoque
    }

    // Método para buscar no caixa (ListaProdutosCaixa)
    private Produto buscarProdutoNoCaixa(String codigo, ListaProdutosCaixa listaProdutosCaixa) {
        for (Produto produto : listaProdutosCaixa.getProdutos()) {
            if (produto.getIdProduto().equals(codigo)) {
                return produto;
            }
        }
        return null;  // Produto não encontrado no caixa
    }

    private void atualizarEstoqueRemovido(Produto produto, int quantidade, ListaProdutosAll estoque) {
        for (Produto p : estoque.getProdutos()) {
            if (p.getIdProduto().equals(produto.getIdProduto())) {
                p.setQuantidadeProduto(p.getQuantidadeProduto() - quantidade);  
                System.out.println("Estoque atualizado para o produto " + p.getNomeProduto() + ". Quantidade restante: " + p.getQuantidadeProduto());
                return;
            }
        }
    }

    public void removerProduto(ListaProdutosCaixa listaProdutosCaixa, ListaProdutosAll estoque) {
        Scanner scanner = new Scanner(System.in);
    
        // Solicita o código do produto a ser removido
        System.out.println("Digite o código do produto para remover: ");
        String codigoProduto = scanner.nextLine();
    
        Produto produto = buscarProdutoNoCaixa(codigoProduto, listaProdutosCaixa);  // Renomeado
        if (produto == null) {
            System.out.println("Erro: Produto não encontrado na lista do caixa.");
            return;  // Produto não encontrado no caixa
        }
    
        // Solicita a quantidade a ser removida
        System.out.println("Informe a quantidade a ser removida do produto " + produto.getNomeProduto() + ": ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Consome o newline
    
        if (quantidade > produto.getQuantidadeProduto()) {
            System.out.println("Erro: Quantidade solicitada maior que a quantidade no caixa.");
            return;
        }
    
        // Remove o produto da lista do caixa
        listaProdutosCaixa.removerProduto(produto, quantidade);
    
        // Atualiza o estoque de volta
        atualizarEstoqueAdicionado(produto, quantidade, estoque);
        System.out.println("Produto " + produto.getNomeProduto() + " removido da lista do caixa. Quantidade: " + quantidade);
    }

    // Atualiza o estoque quando o produto é removido do caixa
    private void atualizarEstoqueAdicionado(Produto produto, int quantidade, ListaProdutosAll estoque) {
        for (Produto p : estoque.getProdutos()) {
            if (p.getIdProduto().equals(produto.getIdProduto())) {
                p.setQuantidadeProduto(p.getQuantidadeProduto() + quantidade);  // Devolve ao estoque
                System.out.println("Estoque atualizado para o produto " + p.getNomeProduto() + ". Quantidade disponível: " + p.getQuantidadeProduto());
                return;
            }
        }
    }
}


