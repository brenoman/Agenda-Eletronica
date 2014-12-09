package padrao;

import AgendaEletronica.CadastroRegistros;
import AgendaEletronica.ExcecaoRegistroJaExistente;
import AgendaEletronica.Registro;

/*
 * Created on 12/09/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author bjrv
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class FachadaAgenda {
	private CadastroRegistros cadastro = new CadastroRegistros();

	public void inserir(Registro novocadastro) {
		try {
			cadastro.inserir(novocadastro);
		} catch (ExcecaoRegistroJaExistente e) {
			e.printStackTrace();
		}
	}
	public void procurar(String nome) {
		cadastro.procurar(nome);
	}
	public void remover(String nome) {
		cadastro.Remover(nome);
	}
}