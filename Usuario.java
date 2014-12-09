/*
 * Created on 11/08/2005
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
public class Usuario {
	private String login;
	private String senha;
	private boolean situacao;

	/**
	 * @param login
	 * @param senha
	 * @param situacao
	 */
	public Usuario(String login, String senha, boolean situacao) {
		super();
		this.login = login;
		this.senha = senha;
		this.situacao = situacao;
	}
	/**
	 * @return Returns the login.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login The login to set.
	 */
	public void setLogin(String login) throws ExcecaoLoginInvalido {
		if  (login == null || login.length() == 0) {
			throw new ExcecaoLoginInvalido();
		}
		this.login = login;
	}

	/**
	 * @return Returns the senha.
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha The senha to set.
	 */
	public void setSenha(String senha) throws ExcecaoSenhaInvalida {
		if (senha == null || senha.length() == 0) {
			throw new ExcecaoSenhaInvalida();
		}
		this.senha = senha;
	}

	/**
	 * @return Returns the situacao.
	 */
	public boolean isSituacao() {
		return situacao;
	}

	/**
	 * @param situacao The situacao to set.
	 */
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public boolean validaSenha(String senha) {
		return this.getSenha().equals(senha);
		
	}
}
