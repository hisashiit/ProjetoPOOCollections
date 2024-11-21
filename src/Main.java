import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "dados.bin";
        String caminhoArquivo2 = "aluno.bin";
        Scanner scan = new Scanner(System.in);
        int verificador, verificador2, verificador3;
        int[] quantidade_alunosG = new int[30];
        int[] quantidade_alunosPG = new int[30];
        int valor = 0;

        // Inicializa os arrays de quantidade de alunos com 0
        for (int i = 0; i < 30; i++) {
            quantidade_alunosG[i] = 0;
            quantidade_alunosPG[i] = 0;
        }

        try (DataInputStream in = new DataInputStream(new FileInputStream(caminhoArquivo))) {
            // Lê o número de disciplinas
            int quantidade_disciplinas = in.readInt();
            System.out.println("Lendo número de disciplinas: " + quantidade_disciplinas);
            Turmas[] turma = new Turmas[30];

            // Processa as disciplinas do arquivo binário
            for (int x = 0; x < quantidade_disciplinas; x++) {
                // Lê informações do professor e da disciplina
                String ano = in.readUTF();
                String periodo = in.readUTF();
                String nomeDisciplina = in.readUTF();
                String codigo = in.readUTF();
                String cargaHoraria = in.readUTF();
                String nomeProfessor = in.readUTF();
                String departamento = in.readUTF();
                String inicioContrato = in.readUTF();
                String cpf = in.readUTF();
                String dataNascimento = in.readUTF();

                Professor professor = new Professor(inicioContrato, departamento, nomeProfessor, cpf, dataNascimento);
                System.out.println("Lendo disciplina: " + nomeDisciplina);
                System.out.println("\n\nProfessor: " + nomeProfessor + ", \nCPF: " + cpf);

                // Lê os estudantes de graduação
                quantidade_alunosG[valor] = in.readInt();
                System.out.println("\nNúmero de estudantes de graduação: " + quantidade_alunosG[valor]);
                Graduacao[] alunosG = new Graduacao[30];
                for (int y = 0; y < quantidade_alunosG[valor]; y++) {
                    // Lê os dados do aluno
                    String estagio = in.readUTF();
                    int cra = in.readInt();
                    String nomeAlunoG = in.readUTF();
                    String cpfAlunoG = in.readUTF();
                    String dataNascimentoAlunoG = in.readUTF();

                    alunosG[y] = new Graduacao(estagio, cra, nomeAlunoG, cpfAlunoG, dataNascimentoAlunoG);
                    System.out.println("\nAluno de Graduação: " + nomeAlunoG + " \nEstágio: " + estagio + " \nCRA: " + cra);
                }

                // Lê os estudantes de pós-graduação
                quantidade_alunosPG[valor] = in.readInt();
                System.out.println("Número de estudantes de pós-graduação: " + quantidade_alunosPG[valor]);
                PosGraduacao[] alunosPG = new PosGraduacao[30];
                for (int y = 0; y < quantidade_alunosPG[valor]; y++) {
                    // Lê os dados do aluno
                    String tema = in.readUTF();
                    int cra = in.readInt();
                    String nomeAlunoPG = in.readUTF();
                    String cpfAlunoPG = in.readUTF();
                    String dataNascimentoAlunoPG = in.readUTF();

                    alunosPG[y] = new PosGraduacao(tema, cra, nomeAlunoPG, cpfAlunoPG, dataNascimentoAlunoPG);
                    System.out.println("\nAluno de Pós-Graduação: " + nomeAlunoPG + " \nTema: " + tema + " \nCRA: " + cra);
                }

                // Cria a turma com os dados lidos e armazena no array
                turma[x] = new Turmas(codigo, nomeDisciplina, cargaHoraria, alunosG, alunosPG, professor, ano, periodo, quantidade_alunosG[valor], quantidade_alunosPG[valor]);
                valor++;
            }

            // Menu de interação com o usuário
            while (true) {
                System.out.println("\n\nDigite 1 para adicionar aluno");
                System.out.println("Digite 2 para adicionar turma");
                System.out.println("Digite 3 para exibir turmas");
                System.out.println("Digite 4 para sair");

                verificador2 = 0;
                verificador3 = 31;
                verificador = scan.nextInt();

                if (verificador >= 4 || verificador < 0) {
                    break;
                }

                if (verificador == 1) {
                    System.out.println("\n");
                    int contador = 0;
                    for (Turmas l : turma) {
                        if (l == null) {
                            break;
                        }
                        System.out.println("Disciplina " + contador + ": " + l.nomeDici());
                        contador++;
                    }

                    do {
                        System.out.println("\nDigite o número da disciplina desejada:");
                        verificador3 = scan.nextInt();

                        if (verificador3 >= 4 || verificador3 < 0) {
                            System.out.println("Numero não esta entre as disciplinas");
                        }

                    } while (0 > verificador3 || verificador3 >= contador);

                    while (verificador2 != 1 && verificador2 != 2) {
                        System.out.println("\nDigite 1 para aluno de graduação e 2 para pós-graduação:");
                        verificador2 = scan.nextInt();
                    }

                    if (verificador2 == 1) {
                        if (quantidade_alunosG[verificador3] == 30) {
                            System.out.println("\nTurma cheia");
                            continue;
                        }
                        System.out.println("\nDigite o estágio:");
                        String estagio = scan.next();

                        System.out.println("\nDigite o CRA:");
                        int cra = scan.nextInt();

                        System.out.println("\nDigite o nome do aluno:");
                        String nomeAlunoG = scan.next();

                        System.out.println("\nDigite o CPF do aluno:");
                        String cpfAlunoG = scan.next();

                        System.out.println("\nDigite a data de nascimento do aluno:");
                        String dataNascimentoAlunoG = scan.next();

                        Graduacao temp = new Graduacao(estagio, cra, nomeAlunoG, cpfAlunoG, dataNascimentoAlunoG);
                        turma[verificador3].adicionarAlunoG(temp, quantidade_alunosG[verificador3]);
                        quantidade_alunosG[verificador3]++;
                    }

                    if (verificador2 == 2) {
                        if (quantidade_alunosPG[verificador3] == 30) {
                            System.out.println("\nTurma cheia");
                            continue;
                        }
                        System.out.println("\nDigite o tema:");
                        String tema = scan.next();

                        System.out.println("\nDigite o CRA:");
                        int cra = scan.nextInt();

                        System.out.println("\nDigite o nome do aluno:");
                        String nomeAlunoPG = scan.next();

                        System.out.println("\nDigite o CPF do aluno:");
                        String cpfAlunoPG = scan.next();

                        System.out.println("\nDigite a data de nascimento do aluno:");
                        String dataNascimentoAlunoPG = scan.next();

                        PosGraduacao temp = new PosGraduacao(tema, cra, nomeAlunoPG, cpfAlunoPG, dataNascimentoAlunoPG);
                        turma[verificador3].adicionarAlunoPG(temp,quantidade_alunosPG[verificador3] );
                        quantidade_alunosPG[verificador3]++;
                    }
                }

                if(verificador == 2) {
                    System.out.println("\nDigite o código da disciplina:");
                    String codigo = scan.next();

                    System.out.println("\nDigite o nome da disciplina:");
                    String nomeDisciplina = scan.next();

                    System.out.println("\nDigite a carga horária:");
                    String cargaHoraria = scan.next();

                    System.out.println("\nDigite o ano:");
                    String ano = scan.next();

                    System.out.println("\nDigite o período:");
                    String periodo = scan.next();

                    System.out.println("\nDigite o nome do professor:");
                    String nomeProfessor = scan.next();

                    System.out.println("\nDigite o departamento do professor:");
                    String departamento = scan.next();

                    System.out.println("\nDigite o início do contrato do professor:");
                    String inicioContrato = scan.next();

                    System.out.println("\nDigite o CPF do professor:");
                    String cpfProfessor = scan.next();

                    System.out.println("\nDigite a data de nascimento do professor:");
                    String dataNascimentoProfessor = scan.next();

                    Professor professor = new Professor(inicioContrato, departamento, nomeProfessor, cpfProfessor, dataNascimentoProfessor);

                    // Inicializar arrays para alunos de graduação e pós-graduação
                    Graduacao[] graduacao = new Graduacao[30];
                    PosGraduacao[] posGraduacao = new PosGraduacao[30];

                    int qtdGrad = 0;
                    int qtdPosGrad = 0;

                    // Criar nova turma e adicionar ao array de turmas
                    turma[valor] = new Turmas(codigo, nomeDisciplina, cargaHoraria, graduacao, posGraduacao, professor, ano, periodo, qtdGrad, qtdPosGrad);
                    valor++;
                }

                if (verificador == 3) {
                    for (Turmas t : turma) {
                        //verifica se acontece algum erro dentro da função printar de turmas
                        if (t != null) {
                            try {
                                t.print();
                            }catch (Exception e) {
                                System.out.println("Erro: " + e);
                            }
                        }
                    }
                }

            }
        //Caso haja erro ao abrir arquivo o catch pega
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
