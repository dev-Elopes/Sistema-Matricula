package sistema.matricula;

import java.util.ArrayList;

public class SistemaMatricula {
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public SistemaMatricula() {
        cursos.add(new Curso("Engenharia de Software", 30));
        cursos.add(new Curso("Ciências da Computação", 30));
        cursos.add(new Curso("Análise e Desenvolvimento de Sistemas", 30));
        cursos.add(new Curso("Programação", 30));
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void matricularAluno(Aluno aluno, Curso curso) throws Exception {
        if (!aluno.validarIdade()) {
            throw new Exception("Aluno deve ter mais de 16 anos.");
        }
        if (!aluno.validarMatricula()) {
            throw new Exception("A matrícula deve ter no mínimo 10 caracteres.");
        }
        if (!curso.temVagas()) {
            throw new Exception("Não há vagas disponíveis para este curso.");
        }
        alunos.add(aluno);
        curso.matricularAluno();
    }
}
