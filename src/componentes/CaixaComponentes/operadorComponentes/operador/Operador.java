package componentes.CaixaComponentes.operadorComponentes.operador;

public class Operador {
    private static int contador = 1;
    private int idOperador;
    private String nomeOperador;
    private String cargo;
    private int CargaHoraria;

    public Operador(
        String nomeOperador, 
        String cargo, 
        int cargaHoraria) {

        this.idOperador = geraId();
        this.nomeOperador = nomeOperador;
        this.cargo = cargo;
        CargaHoraria = cargaHoraria;
    }

    private static int geraId() {
        return contador++;

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