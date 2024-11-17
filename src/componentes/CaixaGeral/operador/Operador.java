package componentes.CaixaGeral.operador;

public class Operador {
    private int idOperador;
    private String nomeOperador;
    private String cargo;
    private int CargaHoraria;

    public Operador(
        int idOperador, 
        String nomeOperador, 
        String cargo, 
        int cargaHoraria) {

        this.idOperador = idOperador;
        this.nomeOperador = nomeOperador;
        this.cargo = cargo;
        CargaHoraria = cargaHoraria;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(int idOperador) {
        this.idOperador = idOperador;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

}