package AgendaEletronica;

import banco.RepositorioRegistrosArray;

/*
 * Created on 22/08/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author dmav
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class CadastroRegistros {
	private RepositorioRegistrosArray registros;
	public CadastroRegistros() {
		
	}
	public CadastroRegistros(RepositorioRegistrosArray c) {
		if (c == null) {
			throw new IllegalArgumentException("Argumento“ + “repositorio nulo");
		}
		this.registros = c;
	}

	public void inserir(Registro novoRegistro) throws ExcecaoRegistroJaExistente {
		if (!registros.existe(novoRegistro.getNome())) {
			registros.inserir(novoRegistro);
		} else {
			throw new ExcecaoRegistroJaExistente("Conta existente");
		}
	}

	public Registro procurar(String nome) {
		return registros.procurar(nome);
	}

	public void Remover(String nome) {
		registros.remover(nome);
	}
}
