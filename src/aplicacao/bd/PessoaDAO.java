package aplicacao.bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aplicacao.entidades.Pessoa;

public class PessoaDAO implements InterfaceDAO<Pessoa> {
	@Override
	public void adiciona(Pessoa pessoa) {
		try {
			String query = "INSERT INTO pessoa VALUES (null, '" + pessoa.getNome() + "', '" + pessoa.getCpf() + "', "
					+ pessoa.getAltura() + ", " + pessoa.getPeso() + ")";
			UtilBD.alterarBD(query);
		} catch (SQLException e) {
			System.err.println("Não foi possível inserir a pessoa no banco!");
		}
	}

	@Override
	public void remove(Pessoa pessoa) {
		try {
			String query = "DELETE FROM pessoa WHERE id = " + pessoa.getId();
			UtilBD.alterarBD(query);
		} catch (SQLException e) {
			System.err.println("Não foi possível remover a pessoa no banco!");
		}
	}

	@Override
	public void atualiza(Pessoa pessoa) {
		try {
			String query = "UPDATE pessoa SET nome = '" + pessoa.getNome() + "', cpf = '" + pessoa.getCpf()
					+ "', altura = " + pessoa.getAltura() + ", peso = " + pessoa.getPeso() + " WHERE pessoa.id = "
					+ pessoa.getId();
			UtilBD.alterarBD(query);
		} catch (SQLException e) {
			System.err.println("Não foi possível atualizar os dados da pessoa no banco!");
		}

	}

	@Override
	public List<Pessoa> busca() {
		try {
			Connection bd = UtilBD.getConexao();
			Statement stm = bd.createStatement();
			String query = "SELECT * FROM pessoa";

			try (ResultSet rs = stm.executeQuery(query)) {

				List<Pessoa> pessoas = new ArrayList<Pessoa>();

				while (rs.next()) {
					Pessoa pessoa = new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"),
							rs.getFloat("altura"), rs.getFloat("peso"));
					pessoas.add(pessoa);
				}

				return pessoas;

			} catch (SQLException e) {
				System.err.println("Falha ao tentar obter o conjunto resultado!");
			}

		} catch (SQLException e) {
			System.err.println("Não foi possível buscar os dados do banco!");
		}
		return null;
	}

}
