package sistema.estoque;

import java.util.List;
import java.util.Scanner;

import componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios;
import componentes.controleEstoque.produtoComponentes.eletronicos.Eletronicos;
import componentes.controleEstoque.produtoComponentes.listaProdutosAll.ListaProdutosAll;
import componentes.controleEstoque.produtoComponentes.produto.Produto;
import componentes.controleEstoque.controleComponentes.busca.garantia.BuscarProdutoGarantia;
import componentes.controleEstoque.controleComponentes.busca.setor.BuscarPrudutoSetor;
import componentes.controleEstoque.controleComponentes.busca.unidade.BuscarProdutoUnidade;
import componentes.controleEstoque.controleComponentes.busca.validade.BuscarProdutoValidade;
import componentes.controleEstoque.controleComponentes.editarEstoque.EditarEstoque;
import componentes.controleEstoque.controleComponentes.removeProdutoEstoque.RemoveProdutoEstoque;
import componentes.controleEstoque.controleComponentes.reposicao.ReposicaoAlimenticio.ReposicaoEstoqueAli;
import componentes.controleEstoque.controleComponentes.reposicao.ReposicaoEletronico.ReposicaoEle;

public class Estoque {

    private ListaProdutosAll listaProdutosAll;
    private EditarEstoque editarEstoque;
    private RemoveProdutoEstoque removeProdutoEstoque;
    private ReposicaoEstoqueAli reposicaoEstoqueAli;
    private ReposicaoEle reposicaoEle;
    private BuscarProdutoGarantia buscarProdutoGarantia;
    private BuscarPrudutoSetor buscarPrudutoSetor;
    private BuscarProdutoValidade buscarProdutoValidade;
    private BuscarProdutoUnidade buscarProdutoUnidade;

    public Estoque(
        ListaProdutosAll listaProdutosAll, 
        List<Alimentocios> lisstaAlimenticios, 
        List<Eletronicos> listaEletronicos) {

        this.listaProdutosAll = listaProdutosAll;
        this.editarEstoque = new EditarEstoque();
        this.removeProdutoEstoque = new RemoveProdutoEstoque(listaProdutosAll);
        this.reposicaoEstoqueAli = new ReposicaoEstoqueAli(lisstaAlimenticios, listaProdutosAll);
        this.reposicaoEle = new ReposicaoEle(listaEletronicos, listaProdutosAll);
        this.buscarProdutoGarantia = new BuscarProdutoGarantia(listaProdutosAll);
        this.buscarPrudutoSetor = new BuscarPrudutoSetor(listaProdutosAll);
        this.buscarProdutoValidade = new BuscarProdutoValidade(listaProdutosAll);
        this.buscarProdutoUnidade = new BuscarProdutoUnidade(); //
        
    }

    public void reposicaoEstoque() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Escolha o tipo de produto para reposição:");
        System.out.println("1 - Alimentício");
        System.out.println("2 - Eletrônico");
        int escolha = scanner.nextInt();
        
        if (escolha == 1) {
            reposicaoEstoqueAli.atualizarQuantidade(); 
        } else if (escolha == 2) {
            reposicaoEle.atualizarQuantidade();  
        } else {
            System.out.println("Opção inválida!");
        }
    }



    public void adicionarProduto(Produto produto) {
        listaProdutosAll.addProdutos(produto);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void removerProduto(String nomeProduto) {
        if (removeProdutoEstoque.removerProdutoNome(nomeProduto)) {
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void listarProdutos() {
        listaProdutosAll.listaProdutos();
    }

    public Produto buscarProdutoPorNome(String nomeProduto) {
        for (Produto produto : listaProdutosAll.getProdutos()) {
            if (produto.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }

    public void editarProduto(String nomeProduto) {
        Produto produto = buscarProdutoPorNome(nomeProduto);
        if (produto != null) {
            editarEstoque.selecionarItemParaEditar(listaProdutosAll.getProdutos());
            System.out.println("Produto editado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public List<Object> buscarPorGarantia(String garantia) {
        return buscarProdutoGarantia.buscarPorGarantia(garantia);
    }

    public List<Object> buscarPorSetor(String setor) {
        return buscarPrudutoSetor.buscarPorSetor(setor);
    }

    public List<Object> buscarPorValidade(String validade) {
        return buscarProdutoValidade.buscarPorValidade(validade);
    }

    public Object buscarPorUnidade(String identificador) {
        Object produtoPorNome = buscarProdutoUnidade.buscarPorNome(identificador);
        if (produtoPorNome != null) {
            return produtoPorNome;
        }
        return buscarProdutoUnidade.buscarPorId(identificador);
    }
    

}
