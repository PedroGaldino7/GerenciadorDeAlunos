public class Materia {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Materia(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Materia [nome=" + nome + ", codigo=" + codigo + ", cargaHoraria=" + cargaHoraria + "]";
    }
}