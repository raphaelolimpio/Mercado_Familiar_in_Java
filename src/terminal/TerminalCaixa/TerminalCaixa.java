package terminal.TerminalCaixa;

import java.util.List;
import componentes.controleEstoque.produtoComponentes.listaProdutosAll.ListaProdutosAll;
import componentes.vendas.ListaPrdutosCaixa.ListaProdutosCaixa;
import sistema.caixaMercado.CaixaMercado;

public class TerminalCaixa {
    public void listarCaixas(List<CaixaMercado> caixas) {
        for (int i = 0; i < caixas.size(); i++) {
            System.out.println("Caixa " + (i + 1) + ": " + caixas.get(i).getNomeOperador());
        }
    }

    public CaixaMercado selecionarCaixa(List<CaixaMercado> caixas, int caixaSelecionado) {
        return caixas.get(caixaSelecionado - 1);
    }

    public void iniciarRemocaoProduto(ListaProdutosCaixa listaProdutosCaixa, ListaProdutosAll estoque) {
        // Chama a função de remoção de produto
        CaixaMercado caixa = new CaixaMercado("Operador 1"); // Exemplo: você selecionaria o operador aqui
        caixa.removerProduto(listaProdutosCaixa, estoque);
    }
}
