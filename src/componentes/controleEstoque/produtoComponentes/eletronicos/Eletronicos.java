package componentes.controleEstoque.produtoComponentes.eletronicos;

public class Eletronicos {
    public int idEletronicos;
    public String setor;
    public String nomeEletronicos;
    public double valorEletronicos;
    public String garantiaEletronicos;
    public String marcaEletronicos;
    public int quantidadeEletronicos;


    public Eletronicos(

        int idEletronicos, 
        String setor, 
        String nomeEletronicos, 
        double valorEletronicos,
        String garantiaEletronicos,
        String marcaEletronicos, 
        int quantidadeEletronicos) {
            
        this.idEletronicos = idEletronicos;
        this.setor = setor;
        this.nomeEletronicos = nomeEletronicos;
        this.valorEletronicos = valorEletronicos;
        this.garantiaEletronicos = garantiaEletronicos;
        this.marcaEletronicos = marcaEletronicos;
        this.quantidadeEletronicos = quantidadeEletronicos;
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

    public int getIdEletronicos() {
        return idEletronicos;
    }

    public void setIdEletronicos(int idEletronicos) {
        this.idEletronicos = idEletronicos;
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
