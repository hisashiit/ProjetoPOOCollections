public class Professor extends Pessoa {
    private String inicioContrato;
    private String departamento;


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
}
