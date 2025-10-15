public class Alunos {

    private String nome;
    private String matricula;
    private String notas;

    public Alunos(String nome, String matricula, String notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public String getNotas() {
        return notas;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Alunos [nome=" + nome + ", matricula=" + matricula + ", notas=" + notas + "]";
    }
}
