package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.DAOFuncionario;
import model.Funcionario;

public class TelaVisualizacao extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField campoPesquisa;
	private JButton botaoBuscar;
	private JButton voltar;

	private List<JButton> deletarButtons = new ArrayList<>();
	private List<JButton> atualizarButtons = new ArrayList<>();

	private JPanel painelPrincipal;

	public TelaVisualizacao() {
		setTitle("Visualizar");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel titulo = new JLabel("Funcionários", SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		add(titulo, BorderLayout.NORTH);

		voltar = new JButton("Voltar");
		voltar.setFont(new Font("Arial", Font.PLAIN, 14));
		voltar.setPreferredSize(new Dimension(100, 30));
		JPanel painelTopo = new JPanel();
		painelTopo.add(voltar);
		add(painelTopo, BorderLayout.SOUTH);

		DAOFuncionario dao = new DAOFuncionario();
		List<Funcionario> list = dao.listarFuncionario();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

		Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border lineBorder = BorderFactory.createLineBorder(java.awt.Color.BLACK);

		Font font = new Font("Arial", Font.PLAIN, 18);

		for (Funcionario funcionario : list) {
			JPanel painel = new JPanel(new GridLayout(0, 1));
			painel.setBorder(BorderFactory.createCompoundBorder(lineBorder, border));

			JLabel nomeLabel = new JLabel("Nome: " + funcionario.getNome(), SwingConstants.CENTER);
			nomeLabel.setFont(font);
			painel.add(nomeLabel);

			JLabel idadeLabel = new JLabel("Idade: " + funcionario.getIdade(), SwingConstants.CENTER);
			idadeLabel.setFont(font);
			painel.add(idadeLabel);

			JLabel cargoLabel = new JLabel("Cargo: " + funcionario.getCargo(), SwingConstants.CENTER);
			cargoLabel.setFont(font);
			painel.add(cargoLabel);

			JLabel contratacaoLabel = new JLabel("Contratação: " + format.format(funcionario.getData_contratacao()),
					SwingConstants.CENTER);
			contratacaoLabel.setFont(font);
			painel.add(contratacaoLabel);

			JLabel telefoneLabel = new JLabel("Telefone: " + funcionario.getTelefone(), SwingConstants.CENTER);
			telefoneLabel.setFont(font);
			painel.add(telefoneLabel);

			JPanel painelBotoes = new JPanel();
			painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
			JButton atualizar = new JButton("Atualizar");
			atualizar.setFont(new Font("Arial", Font.PLAIN, 14));
			atualizar.setActionCommand(String.valueOf(funcionario.getId()));
			atualizarButtons.add(atualizar);
			JButton deletar = new JButton("Deletar");
			deletar.setFont(new Font("Arial", Font.PLAIN, 14));
			deletar.setActionCommand(String.valueOf(funcionario.getId()));
			deletarButtons.add(deletar);
			painelBotoes.add(atualizar);
			painelBotoes.add(Box.createHorizontalStrut(5));
			painelBotoes.add(deletar);

			painel.add(painelBotoes);

			painelPrincipal.add(painel);
			painelPrincipal.add(Box.createVerticalStrut(10));
		}

		add(new JScrollPane(painelPrincipal));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setVisible(true);
	}

	public String getTextoPesquisa() {
		return campoPesquisa.getText();
	}

	public void botaoBuscar(ActionListener listener) {
		botaoBuscar.addActionListener(listener);
	}

	public void botaoVoltar(ActionListener listener) {
		voltar.addActionListener(listener);
	}

	public void adicionarActionListenerAtualizar(ActionListener listener, JButton atualizar) {
		atualizar.addActionListener(listener);
	}

	public List<JButton> getAtualizarButtons() {
		return atualizarButtons;
	}

	public void botaoDeletar(ActionListener listener, JButton deletar) {
		deletar.addActionListener(listener);
	}

	public List<JButton> getDeletarButtons() {
		return deletarButtons;
	}

	public void removerPainelFuncionario(JPanel funcionario) {
		painelPrincipal.remove(funcionario);
		painelPrincipal.revalidate();
		painelPrincipal.repaint();
	}

}
