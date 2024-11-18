import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Bem vindo, inicialize as disciplinas! \n");

        int quantidade_disciplinas, quantidade_alunosG, quantidade_alunosPG, cra;
        String nome, cpf, dataNascimento, tema, ano, periodo, nomeDisciplina, codigo, cargaHoraria, nomeProfessor, departamento, inicioContrato, estagio;
        Professor professor;


        System.out.print("Digite a quantidade de disciplinas: ");
        quantidade_disciplinas = sc.nextInt();
        sc.nextLine();
        Turmas[] turma = new Turmas[quantidade_disciplinas];
        for (int x = 0; x < quantidade_disciplinas; x++) {
            System.out.print("Ano: ");
            ano = sc.nextLine();

            System.out.print("Período:");
            periodo = sc.nextLine();

            System.out.print("Nome da disciplina: ");
            nomeDisciplina = sc.nextLine();

            System.out.print("Código da disciplina: ");
            codigo = sc.nextLine();

            System.out.print("Carga horária: ");
            cargaHoraria = sc.nextLine();

            System.out.print("Nome do professor: ");
            nomeProfessor = sc.nextLine();
            System.out.print("Departamento: ");
            departamento = sc.nextLine();
            System.out.print("Data de início do contrato: ");
            inicioContrato = sc.nextLine();
            System.out.print("CPF do professor: ");
            cpf = sc.nextLine();
            System.out.print("Data de nascimento do professor: ");
            dataNascimento = sc.nextLine();

            professor = new Professor(inicioContrato, departamento, nomeProfessor, cpf, dataNascimento);

            System.out.print("Quantidade de alunos em graduação na turma " + quantidade_disciplinas + "");
            quantidade_alunosG = sc.nextInt();
            sc.nextLine();
            Graduacao[] alunosG = new Graduacao[quantidade_alunosG];

            for (int y = 0; y < quantidade_alunosG; y++) {
                System.out.print("Estágio do aluno: ");
                estagio = sc.nextLine();
                System.out.print("CRA do aluno: ");
                cra = sc.nextInt();
                sc.nextLine();
                System.out.print("Nome do aluno: ");
                nome = sc.nextLine();
                System.out.print("CPF do aluno: ");
                cpf = sc.nextLine();
                System.out.print("Data de nascimento do aluno: ");
                dataNascimento = sc.nextLine();

                alunosG[y] = new Graduacao(estagio, cra, nome, cpf, dataNascimento);
            }

            System.out.print("Quantidade de alunos em pós-graduação na turma " + quantidade_disciplinas + "");
            quantidade_alunosPG = sc.nextInt();
            sc.nextLine();
            PosGraduacao[] alunosPG = new PosGraduacao[quantidade_alunosPG];

            for (int y = 0; y < quantidade_alunosPG; y++) {
                System.out.print("Tema: ");
                tema = sc.nextLine();
                System.out.print("CRA: ");
                cra = sc.nextInt();
                sc.nextLine();
                System.out.print("Nome: ");
                nome = sc.nextLine();
                System.out.print("CPF: ");
                cpf = sc.nextLine();
                System.out.print("Data de nascimento: ");
                dataNascimento = sc.nextLine();

                alunosPG[y] = new PosGraduacao(tema, cra, nome, cpf, dataNascimento);
            }


            turma[x] = new Turmas(codigo, nomeDisciplina, cargaHoraria, alunosG, alunosPG, professor, ano, periodo);
            System.out.print(professor+"\n");
            int j = 0;
            while (j<quantidade_alunosG) {
                System.out.print(alunosG[j] + "\n");
                j = j + 1;
            }

            j = 0;
            while (j<quantidade_alunosPG) {
                System.out.print(alunosPG[j] + "\n");
                j = j + 1;
            }

        }
    }
}
