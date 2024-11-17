package componentes.controleEstoque.produto.listaProdutosAll;

import java.util.ArrayList;
import java.util.List;

import componentes.controleEstoque.produto.alimenticios.Alimentocios;
import componentes.controleEstoque.produto.eletronicos.Eletronicos;



public class ListaProdutosAll {

    public List<Object> produtos;

    public ListaProdutosAll() {
        produtos = new ArrayList<>();
    }

    public void addProdutos(Object produto) {
        produtos.add(produto);
        System.out.println("produto adicionado: " + produto);
    }
    public void listaProdutos() {
        System.out.println("ListaProdutos: ");
        for (Object produto : produtos){
            if (produto instanceof Alimentocios){
                Alimentocios alimenticio = (Alimentocios) produto;
                System.out.println("Produto Alimentício: ");
                System.out.println("Nome: " + alimenticio.getNomeAlimenticios());
                System.out.println("Setor: " + alimenticio.getSetor());
                System.out.println("Valor: " + alimenticio.getValorAlimenticios());
                System.out.println("Validade: " + alimenticio.getValidadeAlimenticios());
                System.out.println("Quantidade: " + alimenticio.getQuantidadeAlimenticios());
                System.out.println("====================================");
            }else if (produto instanceof Eletronicos){
                Eletronicos eletronico = (Eletronicos) produto; //
                System.out.println("Produto Eletrônico: ");
                System.out.println("Nome: " + eletronico.getNomeEletronicos());
                System.out.println("Setor: " + eletronico.getSetor());
                System.out.println("Valor: " + eletronico.getValorEletronicos());
                System.out.println("Garantia: " + eletronico.getGarantiaEletronicos());
                System.out.println("Quantidade: " + eletronico.getQuantidadeEletronicos());
                System.out.println("====================================");
            }
        }

    }
    

    public List<Object> getProdutos() {
        return produtos;
    }
}
