import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAlunos {
    private List<Alunos> alunos;
    private final String arquivo = "alunos.txt";

    public GerenciadorAlunos(){
        this.alunos = new ArrayList<>();
    }
}
