package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DAOFuncionario;
import model.Funcionario;
import view.TelaAtualizacao;
import view.TelaInicial;

public class TelaAtualizarController {

	private TelaAtualizacao view;
	private DAOFuncionario dao;
	private Funcionario funcionario;

	public TelaAtualizarController(TelaAtualizacao view, Funcionario funcionario) {
		this.view = view;
		this.funcionario = funcionario;
		this.dao = new DAOFuncionario();

		this.view.botaoAtualizar(new AtualizarListener());

	}

	class AtualizarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Funcionario atualizado = view.getFuncionario();
			dao.updateFuncionario(atualizado);
			view.dispose();

			TelaInicial telaInicial = new TelaInicial();
			new TelaInicialController(telaInicial);

		}
	}

}
