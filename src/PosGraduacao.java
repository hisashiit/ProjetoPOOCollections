import java.io.Serializable;
public class PosGraduacao extends Estudantes implements Serializable, Printar  {
    private String tema;

    public PosGraduacao(String tema, int cra, String nome, String cpf, String dataNascimento) {
        super(cra, nome, cpf, dataNascimento);
        this.tema = tema;
    }

    public String toString() {
        return super.toString() + " EstudantePosGraduacao{" +
                "tema= '" + tema + "'" + '}';
    }

    public void print() {
        super.print();
        System.out.print(" EstudantePosGraduacao{" + "tema= '" + tema + "'" + '}');
    }

}
