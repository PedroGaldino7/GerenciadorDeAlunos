public class Avaliacao {
    private Aluno aluno;
    private Materia materia;
    private float n1;
    private float n2;
    private float n3;
    private float media;

    public Avaliacao(Aluno aluno, Materia materia, float nota1, float nota2, float nota3) {
        this.aluno = aluno;
        this.materia = materia;
        this.n1 = nota1;
        this.n2 = nota2;
        this.n3 = nota3;
    }

    public float calcularMedia() {
        this.media = (n1 + n2 + n3) / 3;
        return media;
    }

    @Override
    public String toString() {
        return "Avaliacao [aluno=" + aluno + ", materia=" + materia + ", n1=" + n1 + ", n2=" + n2 + ", n3=" + n3
                + ", media=" + media + "]";
    }
}
