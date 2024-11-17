package componentes.controleEstoque.produtoComponentes.produto;

public interface Produto {

    String getIdProduto();
    String getNomeProduto();
    double getValorProduto();
    float getQuantidadeProduto();
    void setQuantidadeProduto(float quantidade);

}
