package componentes.controleEstoque.produto.cadastro;

import java.util.ArrayList;
import java.util.List;

import componentes.controleEstoque.produto.alimenticios.Alimentocios;
import componentes.controleEstoque.produto.eletronicos.Eletronicos;
import componentes.controleEstoque.produto.listaProdutosAll.ListaProdutosAll;

public class Cadastro {

    private List<Alimentocios> listaAlimenticios;
    private List<Eletronicos> listaEletronicos;
    private ListaProdutosAll listaProdutosAll;

    public Cadastro(ListaProdutosAll listaProdutosAll) {

        this.listaProdutosAll = listaProdutosAll;
        listaAlimenticios = new ArrayList<>();
        listaEletronicos = new ArrayList<>();
    }

    // Método para adicionar um produto alimentício
    public void adicionarAlimenticio(Alimentocios alimenticio) {
        listaAlimenticios.add(alimenticio);
        listaProdutosAll.addProdutos(alimenticio);
        System.out.println("Produto alimentício adicionado: " + alimenticio.getNomeAlimenticios());
    }

    // Método para adicionar um produto eletrônico
    public void adicionarEletronico(Eletronicos eletronico) {
        listaEletronicos.add(eletronico);
        listaProdutosAll.addProdutos(eletronico);
        System.out.println("Produto eletrônico adicionado: " + eletronico.getNomeEletronicos());
    }

    // Método para listar todos os produtos alimentícios
    public void listarAlimenticios() {
        System.out.println("Produtos Alimentícios:");
        for (Alimentocios alimenticio : listaAlimenticios) {
            System.out.println("- " + alimenticio.getNomeAlimenticios());
        }
    }

    // Método para listar todos os produtos eletrônicos
    public void listarEletronicos() {
        System.out.println("Produtos Eletrônicos:");
        for (Eletronicos eletronico : listaEletronicos) {
            System.out.println("- " + eletronico.getNomeEletronicos());
        }
    }
}
