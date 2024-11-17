package componentes.CaixaComponentes.caixaMercado.CofreCaixa;

import java.util.HashMap;
import java.util.Map;

public class CofreCaixa {
    
    private Map<Integer, Double> cofre;

    public CofreCaixa() {
        cofre = new HashMap<>();
    }

    public void adicionarLucro(int numeroCaixa, double lucro) {
        cofre.put(numeroCaixa, cofre.getOrDefault(numeroCaixa, 0.0) + lucro);
    }
    
    public double consultarLucroTotal(int numeroCaixa) {
        return cofre.getOrDefault(numeroCaixa, 0.0);
    }
    
    public void exibirLucros() {
        System.out.println("Lucros por Caixa: ");
        for (Map.Entry<Integer, Double> entry : cofre.entrySet()) {
            System.out.println("Caixa " + entry.getKey() + ": " + entry.getValue());
        }
    }

    // Getter para acessar o cofre
    public Map<Integer, Double> getCofre() {
        return cofre;
    }
}
