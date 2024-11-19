import java.io.Serializable;

public class Disciplina{
    protected String codigo;
    protected String nomeDisciplina;
    protected String cargaHoraria;

    public Disciplina(String codigo, String nomeDisciplina, String cargaHoraria) {
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "codigo='" + codigo + '\'' +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                ", cargaHoraria='" + cargaHoraria + '\'' +
                '}';
    }
}
