package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton cadastro;
	private JButton visualizar;
	private JButton sair;

	public TelaInicial() {
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout());

		JLabel titulo = new JLabel("Cadastro de Funcionários", SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		add(titulo, BorderLayout.NORTH);

		JPanel painel = new JPanel();
		painel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		cadastro = new JButton("Cadastro");
		visualizar = new JButton("Visualizar");
		sair = new JButton("Sair");

		Dimension tamanhoBotao = new Dimension(120, 30);
		cadastro.setPreferredSize(tamanhoBotao);
		visualizar.setPreferredSize(tamanhoBotao);
		sair.setPreferredSize(tamanhoBotao);

		gbc.gridx = 0;
		gbc.gridy = 0;
		painel.add(cadastro, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		painel.add(visualizar, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		painel.add(sair, gbc);

		add(painel, BorderLayout.CENTER);

		getContentPane().setBackground(Color.LIGHT_GRAY);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setVisible(true);

	}

	public void botaoCadastrar(ActionListener listener) {
		cadastro.addActionListener(listener);
	}

	public void botaoVisualizar(ActionListener listener) {
		visualizar.addActionListener(listener);
	}

	public void botaoSair(ActionListener listener) {
		sair.addActionListener(listener);
	}

}
