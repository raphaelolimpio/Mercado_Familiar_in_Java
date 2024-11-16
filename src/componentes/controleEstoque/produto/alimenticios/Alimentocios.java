package componentes.controleEstoque.produto.alimenticios;

public class Alimentocios {

    public int idAlimenticios;
    public String setor;
    public String nomeAlimenticios;
    public double valorAlimenticios;
    public String validadeAlimenticios;
    public int quantidadeAlimenticios;

    public Alimentocios(

        int idAlimenticios, 
        String setor, 
        String nomeAlimenticios, 
        double valorAlimenticios,
        String validadeAlimenticios, 
        int quantidadeAlimenticios) {
            
        this.idAlimenticios = idAlimenticios;
        this.setor = setor;
        this.nomeAlimenticios = nomeAlimenticios;
        this.valorAlimenticios = valorAlimenticios;
        this.validadeAlimenticios = validadeAlimenticios;
        this.quantidadeAlimenticios = quantidadeAlimenticios;
    }

    public int getIdAlimenticios() {
        return idAlimenticios;
    }

    public void setIdAlimenticios(int idAlimenticios) {
        this.idAlimenticios = idAlimenticios;
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


}
