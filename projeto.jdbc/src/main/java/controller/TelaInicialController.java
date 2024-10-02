package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.TelaCadastro;
import view.TelaInicial;
import view.TelaVisualizacao;

public class TelaInicialController {

	private TelaInicial view;

	public TelaInicialController(TelaInicial view) {
		this.view = view;
		this.view.botaoCadastrar(new CadastrarListener());
		this.view.botaoVisualizar(new VisualizarListener());
		this.view.botaoSair(new SairListener());

	}

	class VisualizarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			TelaVisualizacao telaVisualizacao = new TelaVisualizacao();
			new TelaVisualizacaoController(telaVisualizacao);
			view.dispose();

		}

	}

	class CadastrarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TelaCadastro telaCadastro = new TelaCadastro();
			new TelaCadastroController(telaCadastro);
			view.dispose();

		}
	}

	class SairListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja fechar o programa?", "Confirmação",
					JOptionPane.YES_NO_OPTION);

			if (confirmacao == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Encerrando programa");
				view.dispose();
			}

		}

	}

}
