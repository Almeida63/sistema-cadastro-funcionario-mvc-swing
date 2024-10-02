package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.DAOFuncionario;
import model.Funcionario;
import view.TelaAtualizacao;
import view.TelaInicial;
import view.TelaVisualizacao;

public class TelaVisualizacaoController {
	
	private TelaVisualizacao view;
	private DAOFuncionario dao;
	
	public TelaVisualizacaoController(TelaVisualizacao view) {
		this.view = view;
		this.view.botaoVoltar(new voltarListener());
		this.dao = new DAOFuncionario();
		
		for(JButton deletar : view.getDeletarButtons()) {
			this.view.botaoDeletar(new deletarListener(), deletar);
		}
		
		configurarAtualizar();
	}
	
	private void configurarAtualizar() {
		List<JButton> atualizarButtons = view.getAtualizarButtons();
		List<Funcionario> funcionarios = dao.listarFuncionario();

		for (int i = 0; i < atualizarButtons.size(); i++) {
			JButton atualizar = atualizarButtons.get(i);
			Funcionario funcionario = funcionarios.get(i);

			atualizar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TelaAtualizacao telaAtualizacao = new TelaAtualizacao(funcionario);
					telaAtualizacao.botaoAtualizar(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Funcionario atualizado = telaAtualizacao.getFuncionario();
							dao.updateFuncionario(atualizado);
							
							JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso");
							
							telaAtualizacao.dispose();
							view.dispose();
							TelaInicial telaInicial = new TelaInicial();
							new TelaInicialController(telaInicial);
							
						}
					});
				}
			});
		}
	}
	
	class voltarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.dispose();
			TelaInicial telaInicial = new TelaInicial();
			new TelaInicialController(telaInicial);
		}
	}
	
	class deletarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton botao = (JButton) e.getSource();
			Long id = Long.parseLong(botao.getActionCommand());
			int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
			
			if (confirmacao == JOptionPane.YES_OPTION) {
				dao.deletarFuncionario(id);
				JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso!");
				JPanel painelFuncionario = (JPanel) botao.getParent().getParent();
				view.removerPainelFuncionario(painelFuncionario);
			}
		}
	}
}
