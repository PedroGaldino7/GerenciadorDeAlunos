import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAvaliacoes {

    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public void adicionarAvaliacao(Avaliacao av){
        avaliacoes.add(av);
    }
}
