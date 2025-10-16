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

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do{
            limparTela();
            
            System.out.println("=== Gerenciador de Alunos ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch(opcao) {
                    case 1:
                        System.out.println("Funcionalidade de cadastrar aluno ainda nao implementada.");
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
                        System.out.println("Opcao invalida! Tente novamente.");
                        pausa(sc);
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida! Por favor, insira um numero.");
                sc.nextLine(); 
                pausa(sc);
                continue; 
            }
        }while(opcao != 0);
    }
}
