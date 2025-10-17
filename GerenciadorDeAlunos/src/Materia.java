public class Materia {
    private String nomeMateria;
    private String codigo;
    private int cargaHoraria;

    public Materia(String nomeMateria, int cargaHoraria, String codigo) {
        this.nomeMateria = nomeMateria;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Materia [nome=" + nomeMateria + ", codigo=" + codigo + ", cargaHoraria=" + cargaHoraria + "]";
    }
}