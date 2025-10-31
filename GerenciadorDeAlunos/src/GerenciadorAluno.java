import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAluno {
    private List<Aluno> alunos;

    public GerenciadorAluno() {
        this.alunos = new ArrayList<>();
    }

    public boolean verificadorAlunoExistente(String matricula){
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public void salvarAlunosEmArquivo(Aluno aluno) {
        try (FileWriter writer = new FileWriter("alunos.txt", true)) {
            writer.write(aluno.getNome() + ";" + aluno.getMatricula() + "\n");
            alunos.add(aluno);
            System.out.println("Aluno salvo com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar o aluno: " + e.getMessage());
        }
    }

    public void carregarAlunosDoArquivo() {
        File arquivo = new File("alunos.txt");

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhum aluno cadastrado ainda.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 2) {
                    Aluno aluno = new Aluno(dados[0], dados[1]);
                    alunos.add(aluno);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar alunos: " + e.getMessage());
        }
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("=== LISTA DE ALUNOS ===");
            for (Aluno a : alunos) {
                System.out.println("- " + a.getNome() + " (Matrícula: " + a.getMatricula() + ")");
            }
        }
    }
    
    public void verificarArquivoVazio() {
        File arquivo = new File("alunos.txt");

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhum aluno cadastrado no arquivo.");
        } else {
            listarAlunos();
        }
    }

    public void excluirAlunoDoArquivo(int index){
        File arquivo = new File("alunos.txt");

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhum aluno para remover.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            List<String> linhas = new ArrayList<>();
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }

            if (index < 0 || index >= linhas.size()) {
                System.out.println("Índice inválido para remoção.");
                return;
            }

            linhas.remove(index);
            if (index < alunos.size()) {
                alunos.remove(index);
                
            }

            try (FileWriter writer = new FileWriter(arquivo, false)) {
                for (String l : linhas) {
                    writer.write(l + "\n");
                }
            }
            
            System.out.println("Aluno removido com sucesso!");
            
        } catch (Exception e) {
            
        }
    }

    public List<Aluno> getAlunos(){
        return alunos;
    }
}
