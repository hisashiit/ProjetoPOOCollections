import java.io.Serializable;
public class Turmas extends Disciplina implements Serializable {
    public Graduacao[] graduacao;
    public PosGraduacao[] posGraduacao;
    public Professor professor;
    private String ano;
    private String periodo;
    public int qtdPosGrad;
    public int qtdGrad;

    public Turmas(String codigo, String nomeDisciplina, String cargaHoraria, Graduacao[] graduacao,
                  PosGraduacao[] posGraduacao, Professor professor, String ano, String periodo, int qtdGrad, int qtdPosGrad) {
        super(codigo, nomeDisciplina, cargaHoraria);
        this.graduacao = graduacao;
        this.posGraduacao = posGraduacao;
        this.professor = professor;
        this.ano = ano;
        this.periodo = periodo;
        this.qtdGrad = qtdGrad;
        this.qtdPosGrad = qtdPosGrad;
    }

    public void adicionarAlunoG(Graduacao temp, int x){
        this.graduacao[x] = temp;
        this.qtdGrad++;

    }

    public void adicionarAlunoPG(PosGraduacao temp, int x){
        this.posGraduacao[x] = temp;
        this.qtdPosGrad++;
    }

    public String nomeDici(){
        return super.getNomeDisciplina();
    }

    public void print() throws ErroMain {
        int j = 0;
        System.out.println("\n\n---------------------Turma cadastrada--------------------------");
        System.out.print(super.toString() + "\n" + "Ano: '" + ano + "', Periodo: '"+ periodo + "'" + "\n" + "Professor: ");
        professor.print();
        System.out.println(" ");

        if (graduacao[0] == null) {
            throw new ErroMain("Nenhum aluno em graduação foi adicionado a essa turma\n");
        }

        System.out.println("\n\n------------------Alunos da Graduacao cadastrados-----------------------");
        while (j<qtdGrad)
        {
            graduacao[j].print();
            System.out.println(" ");
            j = j+1;
        }
        j = 0;

        if (posGraduacao[0] == null) {
            throw new ErroMain("Nenhum aluno em pós-graduação foi adicionado a essa turma\n");
        }
        System.out.println("\n\n------------------Alunos da Pós-Graduacao cadastrados-----------------------");
        while (j<qtdPosGrad)
        {
            posGraduacao[j].print();
            System.out.println(" ");
            j = j+1;
        }
        System.out.println(" ");
        System.out.println("Fim dos alunos da disciplina: " + nomeDisciplina + " do ano " + ano + " do periodo " + periodo);
    }
}
