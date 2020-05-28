package aplicacao;

import java.util.ArrayList;
import java.util.List;

import aplicacao.bd.PessoaDAO;
import aplicacao.bd.UtilBD;
import aplicacao.entidades.Pessoa;

public class Main {

	public static void main(String[] args) {
		Pessoa a = new Pessoa("Ana", "10082189951", 1.88f, 75.6f);
		Pessoa p = new Pessoa(3, "Daniel", "11111111111", 1.88f, 75.6f);
		
		PessoaDAO pDAO = new PessoaDAO();
		
		UtilBD.initBD();
		pDAO.adiciona(a);
		pDAO.atualiza(p);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas = pDAO.busca();
		
		for (int i=0; i<pessoas.size(); i++)
			pessoas.get(i).apresentaPessoa();
		
		UtilBD.fecharConexao();
	}

}
