import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void limparTela() { 
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausa(Scanner sc) {
        System.out.println("\nPressione ENTER para voltar ao menu:");
        sc.nextLine(); 
    }

    public static int lerOpcao(Scanner sc, String mensagem) {
        int opcao = -1;
        while (true) {
            try {
                System.out.print(mensagem);
                opcao = sc.nextInt();
                sc.nextLine();
                break;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                sc.nextLine();
                continue;
            }
        }
        return opcao;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        GerenciadorAluno gerenciadorAluno = new GerenciadorAluno();
        GerenciadorMateria gerenciadorMateria = new GerenciadorMateria();
        GerenciadorAvaliacoes gerenciadorAvaliacoes = new GerenciadorAvaliacoes();
        
        gerenciadorMateria.carregarMateriasDoArquivo();
        gerenciadorAluno.carregarAlunosDoArquivo();
        gerenciadorAvaliacoes.carregarAvaliacoesDoArquivo(gerenciadorAluno, gerenciadorMateria);

        int opcao = 0;

        do{
            limparTela();

            System.out.println("=== Gerenciador de Alunos ===");
            System.out.println("1. Cadastrar");
            System.out.println("2. Inserir notas do aluno");
            System.out.println("3. Listar");
            System.out.println("0. Sair");
            opcao = lerOpcao(sc, "Escolha uma opcao: ");

                switch(opcao) {
                    case 1:
                    limparTela();
                        System.out.println("=== Cadastrar ===");
                        System.out.println("1. Cadastrar Aluno: ");
                        System.out.println("2. Cadastrar Matéria: ");
                        System.out.println("0. Voltar ao menu principal");
                        int cadOpcao = lerOpcao(sc, "Escolha uma opcao: ");

                        switch(cadOpcao) {
                            case 1:
                            limparTela();
                                System.out.println("Nome do Aluno: ");
                                String nomeAluno = sc.nextLine();
                                System.out.println("Matricula do Aluno: ");
                                String matricula = sc.nextLine();
                                
                                if (gerenciadorAluno.verificadorAlunoExistente(matricula)) {
                                    System.out.println("Matricula ja cadastrada! Operacao cancelada.");
                                    pausa(sc);
                                    break;

                                }else {
                                    Aluno aluno = new Aluno(nomeAluno, matricula);
                                    gerenciadorAluno.salvarAlunosEmArquivo(aluno);
                                    pausa(sc);
                                }
                                break;

                            case 2:
                            limparTela();
                                System.out.println("Nome da matéria: ");
                                String nomeMateria  = sc.nextLine();
                                System.out.println("Carga horária da matéria (em horas): ");
                                int cargaHoraria = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Código da matéria: ");
                                String codigo = sc.nextLine();
                                
                                if (gerenciadorMateria.verificadorMateriaExistente(codigo)) {
                                    System.out.println("Matéria ja cadastrada! Operacao cancelada.");
                                    pausa(sc);
                                    break;

                                }else {
                                    Materia materia = new Materia(nomeMateria, cargaHoraria, codigo);
                                    gerenciadorMateria.salvarMateriasEmArquivo(materia);
                                    pausa(sc);
                                }
                                break;

                            case 0:
                                System.out.println("\nVoltando ao menu principal...");
                                pausa(sc);
                                break;

                            default:
                                System.out.println("\nOpcao invalida! Tente novamente.");
                                pausa(sc);
                                break;
                        }
                        break;

                    case 2:
                    limparTela();

                        System.out.println("=== Inserir notas do aluno ===\n");
                        System.out.println("Selecione o aluno: ");
                            if (gerenciadorAluno.getAlunos().isEmpty()) {
                                System.out.println("Nenhum aluno cadastrado.");
                                pausa(sc);
                                break;
                            }
                            else{
                                for(int i = 0; i < gerenciadorAluno.getAlunos().size(); i++){
                                    Aluno a = gerenciadorAluno.getAlunos().get(i);
                                    System.out.println((i + 1) + ". " + a.getNome() + " (Matrícula: " + a.getMatricula() + ")");
                                }
                                System.out.print("Escolha uma opcao: ");
                                int alunoIndex = sc.nextInt() - 1;
                                sc.nextLine();

                                Aluno alunoSelecionado = gerenciadorAluno.getAlunos().get(alunoIndex);

                                limparTela();
                                System.out.println("\nSelecione a matéria: ");
                                if (gerenciadorMateria.getMaterias().isEmpty()) {
                                    System.out.println("Nenhuma matéria cadastrada.");
                                    pausa(sc);
                                    break;
                                }
                                else{
                                    for(int i = 0; i < gerenciadorMateria.getMaterias().size(); i++){
                                        Materia m = gerenciadorMateria.getMaterias().get(i);
                                        System.out.println((i + 1) + ". " + m.getNomeMateria() + " (Código: " + m.getCodigo() + ")");
                                    }
                                    System.out.print("Escolha uma opcao: ");
                                    int materiaIndex = sc.nextInt() - 1;
                                    sc.nextLine();

                                    Materia materiaSelecionada = gerenciadorMateria.getMaterias().get(materiaIndex);

                                    limparTela();
                                    System.out.println("\nInsira as notas do aluno:");
                                    System.out.print("Nota 1: ");
                                    float n1 = sc.nextFloat();
                                    System.out.print("Nota 2: ");
                                    float n2 = sc.nextFloat();
                                    System.out.print("Nota 3: ");
                                    float n3 = sc.nextFloat();
                                    sc.nextLine();

                                    Avaliacao avaliacao = new Avaliacao(alunoSelecionado, materiaSelecionada, n1, n2, n3);
                                    gerenciadorAvaliacoes.salvarAvaliacaoEmArquivo(avaliacao);
                                    pausa(sc);
                                }
                            }
                        break;

                    case 3:
                    limparTela();
                        System.out.println("=== Listar ===");
                        System.out.println("1. Listar Alunos: ");
                        System.out.println("2. Listar Matérias: ");
                        System.out.println("3. Listar Avaliações: ");
                        System.out.println("0. Voltar ao menu principal");
                        int listOpcao = lerOpcao(sc, "Escolha uma opcao: ");

                        switch(listOpcao) {
                            case 1:
                            limparTela();
                                gerenciadorAluno.verificarArquivoVazio();
                                pausa(sc);
                                break;

                            case 2:
                            limparTela();
                                gerenciadorMateria.verificarArquivoVazio();
                                pausa(sc);
                                break;

                            case 3:
                            limparTela();
                                System.out.println("=== Avaliações Cadastradas ===\n");
                                System.out.println("Selecione a matéria para listar as avaliações:");
                                if (gerenciadorMateria.getMaterias().isEmpty()) {
                                    System.out.println("Nenhuma matéria cadastrada.");
                                    pausa(sc);
                                    break;
                                }
                                else{
                                    for(int i = 0; i < gerenciadorMateria.getMaterias().size(); i++){
                                        Materia m = gerenciadorMateria.getMaterias().get(i);
                                        System.out.println((i + 1) + ". " + m.getNomeMateria() + " (Código: " + m.getCodigo() + ")");
                                    }
                                    System.out.print("Escolha uma opcao: ");
                                    int materiaIndex = sc.nextInt() - 1;
                                    sc.nextLine();

                                    Materia materiaSelecionada = gerenciadorMateria.getMaterias().get(materiaIndex);

                                    limparTela();
                                    gerenciadorAvaliacoes.listarAvaliacoesPorMateria(materiaSelecionada);
                                    pausa(sc);
                                }
                                break;

                            case 0:
                                System.out.println("\nVoltando ao menu principal...");
                                pausa(sc);
                                break;

                            default:
                                System.out.println("\nOpcao invalida! Tente novamente.");
                                pausa(sc);
                                break;
                        }
                        break;

                    case 0:
                        System.out.println("\nSaindo...");
                        break;

                    default:
                        System.out.println("\nOpcao invalida! Tente novamente.");
                        pausa(sc);
                        break;
                }

        }while(opcao != 0);
    }
}
