package cadastro.funcionario.projeto.jdbc;

import controller.TelaInicialController;
import view.TelaInicial;

public class Main {

	public static void main(String[] args) {

		TelaInicial telaInicial = new TelaInicial();
		new TelaInicialController(telaInicial);

	}

}
