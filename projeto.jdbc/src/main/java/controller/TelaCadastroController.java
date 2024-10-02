package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.DAOFuncionario;
import model.Funcionario;
import view.TelaCadastro;
import view.TelaInicial;
import view.TelaVisualizacao;

public class TelaCadastroController {

	private TelaCadastro view;

	public TelaCadastroController(TelaCadastro view) {
		this.view = view;
		this.view.realizarCadastroBotao(new realizarCadastroListener());
		this.view.voltarPaginaBotao(new voltarListener());
	}

	class realizarCadastroListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			DAOFuncionario dao = new DAOFuncionario();
			Funcionario funcionario = new Funcionario();
			TelaCadastro tela = view;
			
			if(tela.getNome().isEmpty() || tela.getIdade().isEmpty() || tela.getCargo().isEmpty()
					|| tela.getdataContratacao().isEmpty() || tela.getTelefone().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Erro! Todos os campos devem ser preenchidos");
			}else {

			int idadeFormatada = Integer.parseInt(tela.getIdade());
			funcionario.setNome(tela.getNome());
			funcionario.setIdade(idadeFormatada);
			funcionario.setCargo(tela.getCargo());

			String dateContratacao = tela.getdataContratacao();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date dataContratacao = null;
			try {
				dataContratacao = format.parse(dateContratacao);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			funcionario.setData_contratacao(dataContratacao);

			funcionario.setTelefone(tela.getTelefone());
			
			dao.insertFuncionario(funcionario);
			
			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
			
			view.dispose();
			TelaVisualizacao telaVisualizacao = new TelaVisualizacao();
			new TelaVisualizacaoController(telaVisualizacao);
			
			}
	
			
			
		}
	}

	class voltarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Fechando a tela de cadastro e voltando para a tela inicial...");
			view.dispose();
			TelaInicial telaInicial = new TelaInicial();

			new TelaInicialController(telaInicial);

		}
	}

}
