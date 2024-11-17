package sistema.administrativo;

import componentes.CaixaComponentes.operadorComponentes.cadastroOperador.CadastroOperador;
import componentes.CaixaComponentes.operadorComponentes.operador.Operador;
import componentes.CaixaComponentes.operadorComponentes.removerOperador.RemoverOperador;
import componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios;
import componentes.controleEstoque.produtoComponentes.listaProdutosAll.ListaProdutosAll;
import componentes.relatorio.relatorioQualidade.RelatorioQualidade;
import componentes.relatorio.relatorioQuantidade.RelatorioQuantidade;

import java.util.List;
import java.util.Scanner;

public class Administrativo {
    private RelatorioQualidade relatorioQualidade;
    private RelatorioQuantidade relatorioQuantidade;
    private CadastroOperador cadastroOperador;
    private List<Operador> listaOperadores;

    public Administrativo() {
        this.relatorioQualidade = new RelatorioQualidade();
        this.relatorioQuantidade = new RelatorioQuantidade();
        this.cadastroOperador = new CadastroOperador();
    }

    public void adicionarOperador(String nomeOperador, String cargo, int cargaHoraria) {
        Operador operador = new Operador(nomeOperador, cargo, cargaHoraria);
        cadastroOperador.adicionarOperador(operador);
        System.out.println("Operadro Cadastrado com sucesso");
    }

    public void gerarRelatorioQualidade() {
        List<Alimentocios> listaAlimenticios = carregarListaAlimenticios();
        relatorioQualidade.gerarRelatorio(listaAlimenticios);
    }

    public List<Operador> obterListaOperadores() {
        return listaOperadores;
    }

    public void gerarRelatorioQuantidade() {
        ListaProdutosAll listaProdutosAll = carregarListaProdutos();
        relatorioQuantidade.gerarRelatorio(listaProdutosAll);
    }

    private List<Alimentocios> carregarListaAlimenticios() {

        return null;
    }

    private ListaProdutosAll carregarListaProdutos() {

        return null;
    }

    public void removerOperador(Scanner scanner) {
        RemoverOperador removerOperador = new RemoverOperador(listaOperadores);
        removerOperador.removerOperador(scanner);
    }

}
