package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.DateFormatter;

import model.Funcionario;

public class TelaAtualizacao extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField nome;
    private JTextField idade;
    private JTextField cargo;
    private JFormattedTextField dataContratacao;
    private JTextField telefone;
    private JButton atualizarButton;
    private Funcionario funcionario;


    public TelaAtualizacao(Funcionario funcionario) {
        this.funcionario = funcionario;
        setTitle("Tela de atualização de funcionário");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Atualização", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(nomeLabel, gbc);

        nome = new JTextField(funcionario.getNome());
        nome.setFont(new Font("Arial", Font.PLAIN, 16));
        nome.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(nome, gbc);

        JLabel idadeLabel = new JLabel("Idade: ");
        idadeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(idadeLabel, gbc);

        idade = new JTextField(String.valueOf(funcionario.getIdade()));
        idade.setFont(new Font("Arial", Font.PLAIN, 16));
        idade.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(idade, gbc);

        JLabel cargoLabel = new JLabel("Cargo: ");
        cargoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(cargoLabel, gbc);

        cargo = new JTextField(funcionario.getCargo());
        cargo.setFont(new Font("Arial", Font.PLAIN, 16));
        cargo.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(cargo, gbc);

        JLabel dataContratacaoLabel = new JLabel("Contratação: ");
        dataContratacaoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(dataContratacaoLabel, gbc);

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        DateFormatter dataFormatada = new DateFormatter(format);
        dataContratacao = new JFormattedTextField(dataFormatada);
        dataContratacao.setValue(funcionario.getData_contratacao());
        dataContratacao.setFont(new Font("Arial", Font.PLAIN, 16));
        dataContratacao.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel.add(dataContratacao, gbc);

        JLabel telefoneLabel = new JLabel("Telefone: ");
        telefoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 4;
        painel.add(telefoneLabel, gbc);

        telefone = new JTextField(funcionario.getTelefone());
        telefone.setFont(new Font("Arial", Font.PLAIN, 16));
        telefone.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 4;
        painel.add(telefone, gbc);

        JPanel botoesPainel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBotoes = new GridBagConstraints();
        gbcBotoes.insets = new Insets(10, 10, 10, 10);

        atualizarButton = new JButton("Atualizar");
        atualizarButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gbcBotoes.gridx = 1;
        gbcBotoes.gridy = 0;
        gbcBotoes.anchor = GridBagConstraints.EAST;
        botoesPainel.add(atualizarButton, gbcBotoes);

        add(botoesPainel, BorderLayout.SOUTH);
        add(painel, BorderLayout.CENTER);

        getContentPane().setBackground(Color.LIGHT_GRAY);

        setVisible(true);
    }

    public void botaoAtualizar(ActionListener listener) {
        atualizarButton.addActionListener(listener);
    }
    

    public Funcionario getFuncionario() {
        funcionario.setNome(nome.getText());
        funcionario.setIdade(Integer.parseInt(idade.getText()));
        funcionario.setCargo(cargo.getText());
        funcionario.setData_contratacao((Date) dataContratacao.getValue());
        funcionario.setTelefone(telefone.getText());
        return funcionario;
    }
    
    

    
    
  
}


