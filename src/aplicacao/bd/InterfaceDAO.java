package aplicacao.bd;

import java.util.List;

public interface InterfaceDAO<T> {
	public void adiciona(T referencia);
	public void remove(T referencia);
	public List<T> busca();
	public void atualiza(T referencia);
}
