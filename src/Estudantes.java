public class Estudantes extends Pessoa{
    public int cra;

    public Estudantes(int cra, String nome, String cpf, String dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.cra = cra;
    }

    public String toString() {
        return super.toString() + " Estudante{" +
                "cra='" + cra +
                "'}";
    }

    public void print(){
        System.out.print("Estudante{" + "nome= '" + nome + "', CPF= '" + cpf + "', dataNascimento= '" + dataNascimento + "', cra= '" + cra + "'}");
    }
}
