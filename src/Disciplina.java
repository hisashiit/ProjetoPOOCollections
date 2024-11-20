import java.io.Serializable;

public class Disciplina implements Printar{
    protected String codigo;
    protected String nomeDisciplina;
    protected String cargaHoraria;

    public Disciplina(String codigo, String nomeDisciplina, String cargaHoraria) {
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
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
