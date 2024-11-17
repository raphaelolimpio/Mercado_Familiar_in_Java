package componentes.controleEstoque.produtoComponentes.eletronicos;

import componentes.controleEstoque.produtoComponentes.produto.Produto;

public class Eletronicos implements Produto {
    private static int contador = 0;
    private static String prefixo = "21.056.";
    
    private String idEletronicos;
    private String setor;
    public String getIdEletronicos() {
        return idEletronicos;
    }

    public void setIdEletronicos(String idEletronicos) {
        this.idEletronicos = idEletronicos;
    }

    private String nomeEletronicos;
    private double valorEletronicos;
    private String garantiaEletronicos;
    private String marcaEletronicos;
    private int quantidadeEletronicos;
    private float quantidadeProduto;

    public Eletronicos(
            String setor,
            String nomeEletronicos,
            double valorEletronicos,
            String garantiaEletronicos,
            String marcaEletronicos,
            float quantidadeProduto,
            int quantidadeEletronicos) {
        this.idEletronicos = geraId();
        this.setor = setor;
        this.nomeEletronicos = nomeEletronicos;
        this.valorEletronicos = valorEletronicos;
        this.garantiaEletronicos = garantiaEletronicos;
        this.marcaEletronicos = marcaEletronicos;
        this.quantidadeEletronicos = quantidadeEletronicos;
        this.quantidadeProduto = quantidadeProduto;
    }

    private String geraId() {
        String incremento = String.format("%02d", contador);
        contador++;
        return prefixo + incremento;
    }

    @Override
    public String getIdProduto() {
        return idEletronicos;
    }

    @Override
    public String getNomeProduto() {
        return nomeEletronicos;
    }

    @Override
    public double getValorProduto() {
        return valorEletronicos;
    }

    @Override
    public float getQuantidadeProduto() {
        return quantidadeEletronicos;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getNomeEletronicos() {
        return nomeEletronicos;
    }

    public void setNomeEletronicos(String nomeEletronicos) {
        this.nomeEletronicos = nomeEletronicos;
    }

    public double getValorEletronicos() {
        return valorEletronicos;
    }

    public void setValorEletronicos(double valorEletronicos) {
        this.valorEletronicos = valorEletronicos;
    }

    public String getGarantiaEletronicos() {
        return garantiaEletronicos;
    }

    public void setGarantiaEletronicos(String garantiaEletronicos) {
        this.garantiaEletronicos = garantiaEletronicos;
    }

    public String getMarcaEletronicos() {
        return marcaEletronicos;
    }

    public void setMarcaEletronicos(String marcaEletronicos) {
        this.marcaEletronicos = marcaEletronicos;
    }

    public int getQuantidadeEletronicos() {
        return quantidadeEletronicos;
    }

    public void setQuantidadeEletronicos(int quantidadeEletronicos) {
        this.quantidadeEletronicos = quantidadeEletronicos;
    }

    @Override
    public void setQuantidadeProduto(float quantidade) {
        this.quantidadeProduto = quantidade;
    }
}
