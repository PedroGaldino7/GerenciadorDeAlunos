import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorMateria {
    private List<Materia> materias;

    public GerenciadorMateria() {
        this.materias = new ArrayList<>();
    }

    public boolean verificadorMateriaExistente(String codigo){
        for (Materia m : materias) {
            if (m.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    public void salvarMateriasEmArquivo(Materia materia) {
        try (FileWriter writer = new FileWriter("materias.txt", true)) {
            writer.write(materia.getNomeMateria() + ";" + materia.getCargaHoraria() + ";" + materia.getCodigo() + "\n");
            materias.add(materia);
            System.out.println("Matéria salva com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar a matéria: " + e.getMessage());
        }
    }

    public void carregarMateriasDoArquivo() {
        File arquivo = new File("materias.txt");

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhuma matéria cadastrada ainda.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    Materia materia = new Materia(dados[0], Integer.parseInt(dados[1]), dados[2] );
                    materias.add(materia);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar matérias: " + e.getMessage());
        }
    }

    public void listarMaterias() {
        if (materias.isEmpty()) {
            System.out.println("Nenhuma matéria cadastrada.");
            return;

        }else{
                System.out.println("=== LISTA DE MATÉRIAS ===");
            for (Materia m  : materias) {
                System.out.println("- " + m.getNomeMateria() + " / Código: " + m.getCargaHoraria() + " / Carga horária: " + m.getCodigo());
            }
            }
        }

    public void verificarArquivoVazio() {
        File arquivo = new File("materias.txt");

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhuma matéria cadastrada no arquivo.");
        } else {
            listarMaterias();
        }
    }
}
