import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void limparTela() { 
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausa(Scanner sc) {
        System.out.println("\nPressione ENTER para voltar ao menu...");
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
                break;
            }
        }
        return opcao;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do{
            limparTela();

            System.out.println("=== Gerenciador de Alunos ===");
            System.out.println("1. Cadastrar");
            System.out.println("2. Inserir notas do aluno");
            System.out.println("3. Listar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = lerOpcao(sc, "Escolha uma opcao: ");

                switch(opcao) {
                    case 1:
                        System.out.print("Nome do Aluno: ");
                        String nome = sc.nextLine();
                        System.out.print("Matricula do Aluno: ");
                        String matricula = sc.nextLine();
                        Aluno aluno = new Aluno(nome, matricula);
                        System.out.println("Aluno cadastrado: " + aluno);
                        pausa(sc);
                        break;

                    case 2:
                        System.out.println("Funcionalidade de listar alunos ainda nao implementada.");
                        pausa(sc);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("\nOpcao invalida! Tente novamente.");
                        pausa(sc);
                        break;
                }
            
        }while(opcao != 0);
    }
}
