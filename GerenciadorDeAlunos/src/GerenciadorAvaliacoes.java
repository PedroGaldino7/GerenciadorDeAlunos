import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAvaliacoes {
    private List<Avaliacao> avaliacoes;

    public GerenciadorAvaliacoes() {
        this.avaliacoes = new ArrayList<>();
    }

    public void salvarAvaliacaoEmArquivo(Avaliacao avaliacao) {
        try (FileWriter writer = new FileWriter("avaliacoes.txt", true)) {
            writer.write(avaliacao.getAluno().getMatricula() + ";" + 
                         avaliacao.getMateria().getCodigo() + ";" + 
                         avaliacao.getN1() + ";" + 
                         avaliacao.getN2() + ";" + 
                         avaliacao.getN3() + ";" + 
                         avaliacao.getMedia() + "\n");

            avaliacoes.add(avaliacao);
            System.out.println("Avaliação salva com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar a avaliação: " + e.getMessage());
        }
    }
    
    public void carregarAvaliacoesDoArquivo(GerenciadorAluno gerenciadorAluno, GerenciadorMateria gerenciadorMateria) {
        File arquivo = new File("avaliacoes.txt");

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhuma avaliação cadastrada ainda.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                if (dados.length == 6) {
                    String matricula = dados[0];
                    String codigoMateria = dados[1];
                    float n1 = Float.parseFloat(dados[2]);
                    float n2 = Float.parseFloat(dados[3]);
                    float n3 = Float.parseFloat(dados[4]);

                    Aluno aluno = gerenciadorAluno.getAlunos().stream()
                            .filter(a -> a.getMatricula().equals(matricula))
                            .findFirst()
                            .orElse(null);

                    Materia materia = gerenciadorMateria.getMaterias().stream()
                            .filter(m -> m.getCodigo().equals(codigoMateria))
                            .findFirst()
                            .orElse(null);

                    if (aluno == null || materia == null) {
                        System.out.println("Registro ignorado (aluno ou matéria não encontrados): " + linha);
                        continue;
                    }

                    Avaliacao avaliacao = new Avaliacao(aluno, materia, n1, n2, n3);
                    avaliacoes.add(avaliacao);
                }
            }

            System.out.println("✅ Avaliações carregadas com sucesso!");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao carregar avaliações: " + e.getMessage());
        }
    }

    public void listarAvaliacoesPorMateria(Materia materia) {
        System.out.println("Avaliações para a matéria: " + materia.getNomeMateria());
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getMateria().equals(materia)) {
                System.out.println("Aluno: " + avaliacao.getAluno().getNome() + 
                                   " | Notas: " + avaliacao.getN1() + ", " + avaliacao.getN2() + ", " + avaliacao.getN3() + 
                                   " | Média: " + String.format("%.2f", avaliacao.getMedia()));
            }
        }
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

}
