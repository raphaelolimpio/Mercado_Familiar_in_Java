package componentes.controleEstoque.produto.eletronicos;

public class Eletronicos {
    public int idEletronicos;
    public String setor;
    public String nomeEletronicos;
    public double valorEletronicos;
    public String garantiaEletronicos;
    public int quantidadeEletronicos;


    public Eletronicos(

        int idEletronicos, 
        String setor, 
        String nomeEletronicos, 
        double valorEletronicos,
        String garantiaEletronicos, 
        int quantidadeEletronicos) {
            
        this.idEletronicos = idEletronicos;
        this.setor = setor;
        this.nomeEletronicos = nomeEletronicos;
        this.valorEletronicos = valorEletronicos;
        this.garantiaEletronicos = garantiaEletronicos;
        this.quantidadeEletronicos = quantidadeEletronicos;
    }

    public String getSetor() {
        return setor;
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
