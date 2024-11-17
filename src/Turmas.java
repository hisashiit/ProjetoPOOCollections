public class Turmas extends Disciplina {
    private Graduacao[] graduacao;
    private PosGraduacao[] posGraduacao;
    private Professor professor;
    private String ano;
    private String periodo;

    public Turmas(String codigo, String nomeDisciplina, String cargaHoraria, Graduacao[] graduacao,
                  PosGraduacao[] posGraduacao, Professor professor, String ano, String periodo) {
        super(codigo, nomeDisciplina, cargaHoraria);
        this.graduacao = graduacao;
        this.posGraduacao = posGraduacao;
        this.professor = professor;
        this.ano = ano;
        this.periodo = periodo;
    }


}
