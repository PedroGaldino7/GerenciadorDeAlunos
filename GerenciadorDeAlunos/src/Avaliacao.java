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
        this.media = calcularMedia();
    }

    private float calcularMedia() {
        return (n1 + n2 + n3) / 3;
    }
    
    public float getMedia() {
        return media;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public float getN1() {
        return n1;
    }

    public float getN2() {
        return n2;
    }

    public float getN3() {
        return n3;
    }

    public void setN1(float n1) {
        this.n1 = n1;
        this.media = calcularMedia();
    }

    public void setN2(float n2) {
        this.n2 = n2;
        this.media = calcularMedia();
    }

    public void setN3(float n3) {
        this.n3 = n3;
        this.media = calcularMedia();
    }

    @Override
    public String toString() {
        return "Avaliacao [aluno=" + aluno.getNome() + ", materia=" + materia.getNomeMateria() + ", n1=" + n1 + ", n2=" + n2 + ", n3=" + n3
                + ", media=" + media + "]";
    }
}
