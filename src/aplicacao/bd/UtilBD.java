package aplicacao.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilBD {
	private static Connection conexao;

	private static void abrirConexao() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexao = DriverManager.getConnection("jdbc:sqlite:banco.sqlite");
		} catch (SQLException e1) {
			System.err.println("Não foi possível abrir a conexão com o banco!");
		} catch (ClassNotFoundException e2) {
			System.err.println("Ocorreu uma falha ao utilizar o driver!");
		}
	}

	public static void fecharConexao() {
		if (conexao == null)
			return;
		try {
			if (!conexao.isClosed())
				conexao.close();
		} catch (SQLException e) {
			System.err.println("Não foi possível fechar a conexão com o banco!");
		}
	}

	public static Connection getConexao() {
		try {
			if (conexao == null)
				abrirConexao();
			if (conexao.isClosed())
				abrirConexao();
		} catch (SQLException e) {
			System.err.println("Não foi possível abrir a conexão com o banco!!");
		}
		return conexao;
	}

	public static void initBD() {
		try {
			conexao = getConexao();
			Statement stm = conexao.createStatement();
			stm.executeUpdate("DROP TABLE IF EXISTS pessoa");

			stm.executeUpdate("CREATE TABLE pessoa (" + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ "nome TEXT NOT NULL," + "cpf TEXT NOT NULL," + "altura REAL NOT NULL," + "peso REAL NOT NULL)");

			stm.executeUpdate("INSERT INTO pessoa VALUES (null, 'João', '12345678900', 1.70, 83.6)");
			stm.executeUpdate("INSERT INTO pessoa VALUES (null, 'Maria', '98765432100', 1.60, 65.2)");
			stm.close();
		} catch (SQLException e) {
			System.err.println("Não foi possível criar o banco!");
		}
	}

	public static void alterarBD(String query) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		stm.executeUpdate(query);
		stm.close();
	}
}
