package componentes.controleEstoque.produtoComponentes.eletronicos;

public class Eletronicos {
    private static int contador = 0;
    private static String prefixo = "21.056.";
    public String idEletronicos;
    public String setor;
    public String nomeEletronicos;
    public double valorEletronicos;
    public String garantiaEletronicos;
    public String marcaEletronicos;
    public int quantidadeEletronicos;


    public Eletronicos(

        String setor, 
        String nomeEletronicos, 
        double valorEletronicos,
        String garantiaEletronicos,
        String marcaEletronicos, 
        int quantidadeEletronicos) {
            
        this.idEletronicos = geraId();
        this.setor = setor;
        this.nomeEletronicos = nomeEletronicos;
        this.valorEletronicos = valorEletronicos;
        this.garantiaEletronicos = garantiaEletronicos;
        this.marcaEletronicos = marcaEletronicos;
        this.quantidadeEletronicos = quantidadeEletronicos;
    }

    private String geraId(){
        String incremento = String.format("%02d", contador);
        contador++;
        return prefixo + incremento;
    }

    public String getIdEletronicos() {
        return idEletronicos;
    }

    public void setIdEletronicos(String idEletronicos) {
        this.idEletronicos = idEletronicos;
    }

    public String getSetor() {
        return setor;
    }

    public String getMarcaEletronicos() {
        return marcaEletronicos;
    }

    public void setMarcaEletronicos(String marcaEletronicos) {
        this.marcaEletronicos = marcaEletronicos;
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

    public int getQuantidadeEletronicos() {
        return quantidadeEletronicos;
    }

    public void setQuantidadeEletronicos(int quantidadeEletronicos) {
        this.quantidadeEletronicos = quantidadeEletronicos;
    }

}
