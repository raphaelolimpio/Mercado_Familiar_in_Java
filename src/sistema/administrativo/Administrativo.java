package sistema.administrativo;

import componentes.CaixaComponentes.caixaMercado.buscarCaixa.BuscarCaixa;
import componentes.CaixaComponentes.caixaMercado.cadastroCaixa.CadastroCaixa;
import componentes.CaixaComponentes.caixaMercado.caixa.Caixa;
import componentes.CaixaComponentes.caixaMercado.listacaixa.ListaCaixa;
import componentes.CaixaComponentes.operadorComponentes.cadastroOperador.CadastroOperador;
import componentes.CaixaComponentes.operadorComponentes.operador.Operador;
import componentes.CaixaComponentes.operadorComponentes.removerOperador.RemoverOperador;
import componentes.controleEstoque.produtoComponentes.alimenticios.Alimentocios;
import componentes.controleEstoque.produtoComponentes.listaProdutosAll.ListaProdutosAll;
import componentes.relatorio.relatorioFaturamento.faturamentoAbaixo.FaturamentoAbaixo;
import componentes.relatorio.relatorioFaturamento.faturamentoDiario.faturamentoDiario.FaturamentoDiario;
import componentes.relatorio.relatorioQualidade.RelatorioQualidade;
import componentes.relatorio.relatorioQuantidade.RelatorioQuantidade;

import java.util.List;
import java.util.Scanner;

public class Administrativo {
    private RelatorioQualidade relatorioQualidade;
    private RelatorioQuantidade relatorioQuantidade;
    private CadastroOperador cadastroOperador;
    private List<Operador> listaOperadores;
    private List<Caixa> listaCaixas;
    private CadastroCaixa cadastroCaixa;
    private FaturamentoAbaixo faturamentoAbaixo;
    private FaturamentoDiario faturamentoDiario;

    public Administrativo() {
        this.relatorioQualidade = new RelatorioQualidade();
        this.relatorioQuantidade = new RelatorioQuantidade();
        this.cadastroOperador = new CadastroOperador();
        this.cadastroCaixa = new CadastroCaixa();
        this.faturamentoAbaixo = new FaturamentoAbaixo();
        this.faturamentoDiario = new FaturamentoDiario();
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

    public void cadastrarCaixa(Caixa caixa) {
        cadastroCaixa.adicionarCaixa(caixa);
    }

    public Caixa buscarCaixa(int numero) {
        BuscarCaixa buscar = new BuscarCaixa(listaCaixas);
        return buscar.buscarPorNumero(numero);
    }

    public List<Caixa> obterListaCaixas() {
        ListaCaixa lista = new ListaCaixa(listaCaixas);
        return lista.caixas;
    }
    public void gerarRelatorioFaturamentoAbaixo() {
        faturamentoAbaixo.gerarRelatorio(listaCaixas);
    }

    public void gerarRelatorioFaturamentoDiario() {
        faturamentoDiario.gerarRelatorio(listaCaixas);
    }


}
