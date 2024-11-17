public class Pessoa {
    protected String nome;
    protected String cpf;  // CPF agora é String
    protected String dataNascimento;

    public Pessoa(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String toString() {
        return "Pessoa{" +
                "nome= '"  + nome + '\'' +
                ", cpf= '" + cpf + '\'' +
                ", dataNascimento= '" + dataNascimento + "'" +
                '}';
    }

}
