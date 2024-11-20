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

    public void print() throws ErroMain {
        if (graduacao == null || posGraduacao == null || professor == null || ano == null || periodo == null ||
                graduacao.length == 0 || posGraduacao.length == 0) {
            throw new ErroMain("Valores não iniciados\n");
        }
        int j = 0;
        System.out.println("\n\n---------------------Turma cadastrada--------------------------");
        System.out.print(super.toString() + "\n" + "Ano: '" + ano + "', Periodo: '"+ periodo + "'" + "\n" + "Professor: ");
        professor.print();
        System.out.println(" ");
        System.out.println("\n\n------------------AlunosDaGraduacao cadastrados-----------------------");
        while (j<qtdGrad)
        {
            graduacao[j].print();
            System.out.println(" ");
            j = j+1;
        }
        j = 0;
        System.out.println("\n\n------------------AlunosDaPosGraduacao cadastrados-----------------------");
        while (j<qtdPosGrad)
        {
            posGraduacao[j].print();
            System.out.println(" ");
            j = j+1;
        }
        System.out.println(" ");
        System.out.println("Fim dos alunos da disciplina: " + nomeDisciplina + " do ano " + ano + " do periodo " + periodo);
        System.out.println("---------------------Fim da turma cadastrada--------------------------");
    }
}
