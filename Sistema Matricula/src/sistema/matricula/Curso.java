package sistema.matricula;

public class Curso {
    private String nome;
    private int vagas;

    public Curso(String nome, int vagas) {
        this.nome = nome;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public boolean temVagas() {
        return vagas > 0;
    }

    public void matricularAluno() {
        if (temVagas()) {
            vagas--;
        }
    }
}
