public class Estudantes extends Pessoa{
    protected int cra;

    public Estudantes(int cra, String nome, String cpf, String dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.cra = cra;
    }

    public String toString() {
        return super.toString() + " Estudante{" +
                "cra='" + cra +
                "'}";
    }
}