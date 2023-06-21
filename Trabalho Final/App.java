import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Hackatona hackatona;
    private static Times[] time;

    public static void main(String[] args) {
        criarTimes();
        atribuirNotas();
        executarMenu();
    }

    private static void criarTimes() {
        System.out.println("===== Criação de Times =====");
        List<Times> times = new ArrayList<>();

        do {
            System.out.println("Time " + (times.size() + 1));
            String nomeTime = lerString("Nome do Time: ");

            Times time = new Times(nomeTime);
            times.add(time);

            int numAlunos = lerNumero("Número de Alunos no Time: ");

            boolean cursosDiferentes = false;
            while (!cursosDiferentes) {
                for (int i = 0; i < numAlunos; i++) {
                    System.out.println("Aluno " + (i + 1));
                    String nomeAluno = lerString("Nome: ");
                    String matricula = lerString("Matrícula: ");
                    String curso = lerCurso();
                    String email = lerString("Email: ");

                    Alunos aluno = new Alunos(matricula, nomeAluno, curso, email);
                    time.addAlunos(aluno);
                }
                
                if (time.getNumAlunos() < 2) {
                    cursosDiferentes = false;
                } 
                else {
                    cursosDiferentes = time.verificarCursosDiferentes();
                }

                if (!cursosDiferentes) {
                    System.out.println("O time deve ter pelo menos um aluno de curso diferente. Por favor, tente novamente.");
                }
            }

        System.out.println("Deseja criar outro time? (s/n)");
        } while (scanner.nextLine().equalsIgnoreCase("s"));

        System.out.println("===== Criação de Times Concluída =====");

        hackatona = new Hackatona(times.toArray(new Times[0]), null);
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerNumero(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
            }
        }
    }

    private static String lerCurso() {
        System.out.println("Cursos:");
        System.out.println("1. ES (Engenharia de Software)");
        System.out.println("2. CC (Ciência da Computação)");
        System.out.println("3. SI (Sistemas de Informação)");
        System.out.println("4. EC (Engenharia da Computação)");
        System.out.println("5. CDIA (Ciência de Dados e Inteligência Artificial)");

        int opcao;
        while (true) {
            opcao = lerNumero("Escolha o número do curso: ");

            if (opcao >= 1 && opcao <= 5) {
                break;
            } else {
                System.out.println("Opção inválida. Digite um número válido.");
            }
        }

        switch (opcao) {
            case 1:
                return "ES";
            case 2:
                return "CC";
            case 3:
                return "SI";
            case 4:
                return "EC";
            case 5:
                return "CDIA";
            default:
                return "";
        }
    }

    public static void atribuirNotas() {
        hackatona.atribuirNotas();
    }

    private static void executarMenu() {
        while (true) {
            exibirMenu();
            int opcao = lerNumero("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    hackatona.listarTimes();
                    break;
                case 2:
                    Times[] vencedor = hackatona.identificadorTimeVencedor();
                    System.out.println("Time Vencedor: " + vencedor[0].getNome());
                    break;
                case 3:
                     hackatona.timesAcimaDe20();
                    break;
                case 4:
                    Scanner in = new Scanner(System.in);
                    System.out.println("Digite o nome do time: ");
                    String nomeTime = in.nextLine();
                    hackatona.timeEspecifico(nomeTime);
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Digite um número válido.");
                    break;
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Listar Times e alunos");
        System.out.println("2. Indentificar o time vencedor");
        System.out.println("3. Identificar os times com nota geral maior que 20");
        System.out.println("4. Mostrar time específico");
        System.out.println("5. Sair");
    }
}
