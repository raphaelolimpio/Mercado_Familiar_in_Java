package componentes.controleEstoque.produtoComponentes.alimenticios;

import componentes.controleEstoque.produtoComponentes.produto.Produto;

public class Alimentocios implements Produto {
    private static int contador = 0;
    private static String prefixo = "10.015.";
    private String idAlimenticios;
    private String setor;
    private String nomeAlimenticios;
    private double valorAlimenticios;
    private String validadeAlimenticios;
    private int quantidadeAlimenticios;

    public Alimentocios(

            String setor,
            String nomeAlimenticios,
            double valorAlimenticios,
            String validadeAlimenticios,
            int quantidadeAlimenticios) {

        this.idAlimenticios = geraId();
        this.setor = setor;
        this.nomeAlimenticios = nomeAlimenticios;
        this.valorAlimenticios = valorAlimenticios;
        this.validadeAlimenticios = validadeAlimenticios;
        this.quantidadeAlimenticios = quantidadeAlimenticios;
    }

    public String getIdAlimenticios() {
        return idAlimenticios;
    }

    public void setIdAlimenticios(String idAlimenticios) {
        this.idAlimenticios = idAlimenticios;
    }

    private String geraId() {
        String incremento = String.format("%02d", contador);
        contador++;
        return prefixo + incremento;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getNomeAlimenticios() {
        return nomeAlimenticios;
    }

    public void setNomeAlimenticios(String nomeAlimenticios) {
        this.nomeAlimenticios = nomeAlimenticios;
    }

    public double getValorAlimenticios() {
        return valorAlimenticios;
    }

    public void setValorAlimenticios(double valorAlimenticios) {
        this.valorAlimenticios = valorAlimenticios;
    }

    public String getValidadeAlimenticios() {
        return validadeAlimenticios;
    }

    public void setValidadeAlimenticios(String validadeAlimenticios) {
        this.validadeAlimenticios = validadeAlimenticios;
    }

    public int getQuantidadeAlimenticios() {
        return quantidadeAlimenticios;
    }

    public void setQuantidadeAlimenticios(int quantidadeAlimenticios) {
        this.quantidadeAlimenticios = quantidadeAlimenticios;
    }

    @Override
    public String getIdProduto() {
        return idAlimenticios;
    }

    @Override
    public String getNomeProduto() {
        return nomeAlimenticios;
    }

    @Override
    public double getValorProduto() {
        return valorAlimenticios;
    }

    @Override
    public int getQuantidadeProduto() {
        return quantidadeAlimenticios;
    }

}
