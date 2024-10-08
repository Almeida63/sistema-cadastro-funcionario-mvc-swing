package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static String url = "jdbc:postgresql://localhost:5432/empresa_db";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	static {
		conectar();
	}

	public Conexao() {
		conectar();
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectou com sucesso!");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
