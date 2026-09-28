package view;

import model.Aluno;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TelaAluno extends JFrame {

    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtEndereco;

    private JButton btnOk;
    private JButton btnLimpar;
    private JButton btnMostrar;
    private JButton btnSair;

    private List<Aluno> alunos = new ArrayList<>();

    public TelaAluno() {

        setTitle("TP02 - LP2");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelSuperior = new JPanel(new GridLayout(3, 2));

        txtNome = new JTextField();
        txtIdade = new JTextField();
        txtEndereco = new JTextField();

        painelSuperior.add(new JLabel("Nome:"));
        painelSuperior.add(txtNome);

        painelSuperior.add(new JLabel("Idade:"));
        painelSuperior.add(txtIdade);

        painelSuperior.add(new JLabel("Endereço:"));
        painelSuperior.add(txtEndereco);

        JPanel painelInferior = new JPanel(new GridLayout(1, 4));

        btnOk = new JButton("Ok");
        btnLimpar = new JButton("Limpar");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");

        painelInferior.add(btnOk);
        painelInferior.add(btnLimpar);
        painelInferior.add(btnMostrar);
        painelInferior.add(btnSair);

        add(painelSuperior, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        btnOk.addActionListener(e -> {

            Aluno aluno = new Aluno();

            aluno.setUuid(UUID.randomUUID());
            aluno.setNome(txtNome.getText());
            aluno.setIdade(Integer.parseInt(txtIdade.getText()));
            aluno.setEndereco(txtEndereco.getText());

            alunos.add(aluno);

            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
        });


        btnLimpar.addActionListener(e -> {
            txtNome.setText("");
            txtIdade.setText("");
            txtEndereco.setText("");
        });


        btnMostrar.addActionListener(e -> {

            String mensagem = "";

            for (Aluno aluno : alunos) {
                mensagem += "ID: " + aluno.getUuid() +
                        "\nNome: " + aluno.getNome() +
                        "\n\n";
            }

            JOptionPane.showMessageDialog(this, mensagem);
        });


        btnSair.addActionListener(e -> {
            System.exit(0);
        });

        setVisible(true);
    }
}