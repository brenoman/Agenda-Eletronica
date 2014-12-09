/*
 * Created on 15/08/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */



/**
 * @author manha
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class RepositorioUsuario implements IRepositorioUsuario {
	private Colecao conjUsuario;
	
	/* (non-Javadoc)
	 * @see com.unibratec.dal.IRepositorioUsuario#incluir(com.unibratec.info.usuarios.Usuario)
	 */
	public void incluir(Usuario usuario) throws ExcecaoUsuarioJaExistente, ExcecaoUsuarioInvalido {
		for (int i = 0; i < conjUsuario.tamanho(); i++) {
			Usuario usu  = (Usuario)conjUsuario.busca(i);
			if (usu.getLogin() == usuario.getLogin()) {
				throw new ExcecaoUsuarioJaExistente();
			}
			
		}
		conjUsuario.inclui(usuario);
	}

	/* (non-Javadoc)
	 * @see com.unibratec.dal.IRepositorioUsuario#excluir(java.lang.String)
	 */
	public void excluir(String login) throws ExcecaoUsuarioInexistente, ExcecaoArgumentoInvalido {
		boolean existe = false;
		for (int i = 0; i < conjUsuario.tamanho(); i++) {
			Usuario usu  = (Usuario)conjUsuario.busca(i);
			if (usu.getLogin() == login) {
				conjUsuario.exclui(usu);
				existe = true;
				break;
			}
			
		}
		if (!existe) {
			throw new ExcecaoUsuarioInexistente();
		}	
	}

	/* (non-Javadoc)
	 * @see com.unibratec.dal.IRepositorioUsuario#alterar(com.unibratec.info.usuarios.Usuario)
	 */
	public void alterar(Usuario usuario) throws ExcecaoUsuarioInexistente, ExcecaoUsuarioInvalido {
		boolean existe = false;
		for (int i = 0; i < conjUsuario.tamanho(); i++) {
			Usuario usu  = (Usuario)conjUsuario.busca(i);
			if (usu.getLogin() == usuario.getLogin()) {
				conjUsuario.exclui(usuario);
				existe = true;
				break;
			}
			
		}
		if (!existe) {
			throw new ExcecaoUsuarioInexistente();
		} else {
			conjUsuario.inclui(usuario);
		}	
	}

	/* (non-Javadoc)
	 * @see com.unibratec.dal.IRepositorioUsuario#consultar(java.lang.String)
	 */
	public boolean consultar(String login) throws ExcecaoArgumentoInvalido {
		boolean existe = false;
		for (int i = 0; i < conjUsuario.tamanho(); i++) {
			Usuario usu  = (Usuario)conjUsuario.busca(i);
			if (usu.getLogin() == login) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	/* (non-Javadoc)
	 * @see com.unibratec.dal.IRepositorioUsuario#buscar(java.lang.String)
	 */
	public Usuario buscar(String login) throws ExcecaoUsuarioInexistente, ExcecaoArgumentoInvalido {
		Usuario usu  = null;
		boolean existe = false;
		for (int i = 0; i < conjUsuario.tamanho(); i++) {
			usu  = (Usuario)conjUsuario.busca(i);
			if (usu.getLogin() == login) {
				existe = true;
				break;
			}
		}
		if (!existe) {
			throw new ExcecaoUsuarioInexistente();
		}
		return usu;
	}

	/* (non-Javadoc)
	 * @see com.unibratec.dal.IRepositorioUsuario#elementos()
	 */
	public Colecao colecao() {
		return conjUsuario;
	}

	/**
	 * @param conjUsuario
	 */
	public RepositorioUsuario(Colecao conjUsuario) {
		super();
		this.conjUsuario = conjUsuario;
	}
}
