package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;

public class DAOFuncionario {

	private Connection connection;

	public DAOFuncionario() {
		connection = Conexao.getConnection();
	}

	public void insertFuncionario(Funcionario funcionario) {

		try {
			String sql = "Insert into funcionario (nome, idade, cargo, data_contratacao,telefone) VALUES(?,?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, funcionario.getNome());
			insert.setInt(2, funcionario.getIdade());
			insert.setString(3, funcionario.getCargo());
			insert.setDate(4, new Date(funcionario.getData_contratacao().getTime()));
			insert.setString(5, funcionario.getTelefone());
			insert.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<Funcionario> listarFuncionario() {
		List<Funcionario> list = new ArrayList<>();

		String sql = "Select * from funcionario";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet select = statement.executeQuery();

			while (select.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(select.getLong("id"));
				funcionario.setNome(select.getString("nome"));
				funcionario.setIdade(select.getInt("idade"));
				funcionario.setCargo(select.getString("cargo"));
				funcionario.setData_contratacao(select.getDate("data_contratacao"));
				funcionario.setTelefone(select.getString("telefone"));

				list.add(funcionario);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	public void updateFuncionario(Funcionario funcionario) {

		String sql = "UPDATE funcionario SET nome = ?, idade = ?, cargo = ?, data_contratacao = ?, telefone = ? WHERE id = ?";

		try {
			PreparedStatement update = connection.prepareStatement(sql);
			update.setString(1, funcionario.getNome());
			update.setInt(2, funcionario.getIdade());
			update.setString(3, funcionario.getCargo());
			update.setDate(4, new Date(funcionario.getData_contratacao().getTime()));
			update.setString(5, funcionario.getTelefone());
			update.setLong(6, funcionario.getId());

			update.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deletarFuncionario(Long id) {

		String sql = "Delete from funcionario where id = " + id;

		try {
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
