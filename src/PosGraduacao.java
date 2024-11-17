public class PosGraduacao extends Estudantes {
    private String tema;

    public PosGraduacao(String tema, int cra, String nome, String cpf, String dataNascimento) {
        super(cra, nome, cpf, dataNascimento);
        this.tema = tema;
    }

    @Override
    public String toString() {
        return super.toString() + " EstudantePosGraduacao{" +
                "tema= '" + tema + '\'' +
                '}';
    }

}
