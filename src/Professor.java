public class Professor extends Pessoa {
    public String inicioContrato;
    public String departamento;


    public Professor(String inicioContrato, String departamento,String nome, String cpf, String dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.inicioContrato = inicioContrato;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + " Professor{" +
                "Departamento= '" + departamento + '\'' +
                ", inicioContrato= '" + inicioContrato + '\'' +
                '}';
    }

    public void print(){
        System.out.print("Professor{" + "nome= '" + nome + "', CPF= '" + cpf + "', dataNascimento= '" + dataNascimento + "', inicioContrato= '"+ inicioContrato
                + ", departamento= '" + departamento + "'}");
    }
}
