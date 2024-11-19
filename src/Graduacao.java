import java.io.Serializable;
public class Graduacao extends Estudantes implements Serializable{
    private String estagio;

    public Graduacao(String estagio, int cra, String nome, String cpf, String dataNascimento) {
        super(cra, nome, cpf, dataNascimento);
        this.estagio = estagio;
    }

    @Override
    public String toString() {
        return super.toString() + " EstudanteGraduacao{" +
                "estagio='" + estagio + "'" +
                '}';
    }

    public void print() {
        super.print();
        System.out.print(" EstudanteGraduacao{" + "estagio='" + estagio + "'" + '}');
    }
}
