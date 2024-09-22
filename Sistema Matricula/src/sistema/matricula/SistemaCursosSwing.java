package sistema.matricula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaCursosSwing extends JFrame {
    private SistemaMatricula sistemaMatricula;
    private JComboBox<String> cursoComboBox;
    private JTextField nomeAlunoField, matriculaAlunoField, idadeAlunoField;
    private JButton matricularButton;

    public SistemaCursosSwing() {
        sistemaMatricula = new SistemaMatricula();
        setTitle("Sistema de Matrícula");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel cursoLabel = new JLabel("Curso:");
        cursoComboBox = new JComboBox<>();
        for (Curso curso : sistemaMatricula.getCursos()) {
            cursoComboBox.addItem(curso.getNome());
        }

        JLabel nomeLabel = new JLabel("Nome do Aluno:");
        nomeAlunoField = new JTextField(20);

        JLabel matriculaLabel = new JLabel("Matrícula:");
        matriculaAlunoField = new JTextField(20);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeAlunoField = new JTextField(5);

        matricularButton = new JButton("Matricular");
        matricularButton.addActionListener(new MatricularAlunoListener());

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(cursoLabel, gbc);

        gbc.gridx = 1;
        add(cursoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nomeLabel, gbc);

        gbc.gridx = 1;
        add(nomeAlunoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(matriculaLabel, gbc);

        gbc.gridx = 1;
        add(matriculaAlunoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(idadeLabel, gbc);

        gbc.gridx = 1;
        add(idadeAlunoField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(matricularButton, gbc);
    }

    private class MatricularAlunoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nome = nomeAlunoField.getText();
                String matricula = matriculaAlunoField.getText();
                int idade = Integer.parseInt(idadeAlunoField.getText());

                Aluno aluno = new Aluno(nome, matricula, idade);
                String cursoNome = (String) cursoComboBox.getSelectedItem();
                Curso cursoSelecionado = null;
                for (Curso curso : sistemaMatricula.getCursos()) {
                    if (curso.getNome().equals(cursoNome)) {
                        cursoSelecionado = curso;
                        break;
                    }
                }

                sistemaMatricula.matricularAluno(aluno, cursoSelecionado);
                JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Idade inválida, deve ser um número.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaCursosSwing sistema = new SistemaCursosSwing();
            sistema.setVisible(true);
        });
    }
}

