import java.io.*;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "dados.bin";
        String caminhoArquivo2 = "aluno.bin";
        try (DataInputStream in = new DataInputStream(new FileInputStream(caminhoArquivo))) {
            // QTD DE DISCIPLINAS
            int quantidade_disciplinas = in.readInt(); //1
            System.out.println("Lendo numero de disciplinas: " + quantidade_disciplinas);
            Turmas[] turma = new Turmas[quantidade_disciplinas];
            for (int x = 0; x < quantidade_disciplinas; x++) {
                String ano = in.readUTF();
                String periodo = in.readUTF();
                String nomeDisciplina = in.readUTF();
                String codigo = in.readUTF();
                String cargaHoraria = in.readUTF();
                String nomeProfessor = in.readUTF();
                String departamento = in.readUTF();
                String inicioContrato = in.readUTF();
                String cpf = in.readUTF();
                String dataNascimento = in.readUTF(); //11
                Professor professor = new Professor(inicioContrato, departamento, nomeProfessor, cpf, dataNascimento);

                System.out.println("Reading discipline: " + nomeDisciplina);
                System.out.println("\n\nProfessor: " + nomeProfessor + ", \nCPF: " + cpf);

                // ESTUDANTES DE GRADUACAO
                int quantidade_alunosG = in.readInt();
                System.out.println("\nLendo numero de estudantes graduados: " + quantidade_alunosG);
                Graduacao[] alunosG = new Graduacao[quantidade_alunosG];
                for (int y = 0; y < quantidade_alunosG; y++) {
                    String estagio = in.readUTF();
                    int cra = in.readInt();
                    String nomeAlunoG = in.readUTF();
                    String cpfAlunoG = in.readUTF();
                    String dataNascimentoAlunoG = in.readUTF();
                    alunosG[y] = new Graduacao(estagio, cra, nomeAlunoG, cpfAlunoG, dataNascimentoAlunoG);
                    System.out.println("\n\nAluno de Graduação: " + nomeAlunoG + " \nEstágio: " + estagio + " \nCRA: " + cra);
                }

                // ESTUDANTES DE POSGRADUACAO
                int quantidade_alunosPG = in.readInt();
                System.out.println("Lendo numero de estudantes de pos graduacao: " + quantidade_alunosPG);
                PosGraduacao[] alunosPG = new PosGraduacao[quantidade_alunosPG];
                for (int y = 0; y < quantidade_alunosPG; y++) {
                    String tema = in.readUTF();
                    int cra = in.readInt();
                    String nomeAlunoPG = in.readUTF();
                    String cpfAlunoPG = in.readUTF();
                    String dataNascimentoAlunoPG = in.readUTF();
                    alunosPG[y] = new PosGraduacao(tema, cra, nomeAlunoPG, cpfAlunoPG, dataNascimentoAlunoPG);
                    System.out.println("\n\nAluno de Pós-Graduação: " + nomeAlunoPG + " \nTema: " + tema + " \nCRA: " + cra);
                }
                turma[x] = new Turmas(codigo, nomeDisciplina, cargaHoraria, alunosG, alunosPG, professor, ano, periodo, quantidade_alunosG, quantidade_alunosPG);

                System.out.println("\n\n---------------------Alunos cadastrados--------------------------");


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
                j = 0;

                while (j < quantidade_disciplinas) {
                    try {
                        turma[j].print();
                    }
                    catch (Exception e) {
                        System.out.println("Erro: " + e + "\n");
                    }
                    j = j + 1;
                }

                // Gravou o objeto da classe Turma criado no arquivo aluno.bin
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminhoArquivo2))) {
                    out.writeObject(turma[x]);
                    System.out.println("Objeto gravado com sucesso!");
                } catch (IOException e) {
                    System.out.println("Erro ao gravar o objeto: " + e.getMessage());
                }

            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
