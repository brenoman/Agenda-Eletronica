/*
 * Created on 18/08/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.unibratec.info.usuarios;

import com.unibratec.dal.usuario.IRepositorioUsuario;
import com.unibratec.excecoes.ExcecaoAcessoBD;
import com.unibratec.info.excecoes.ExcecaoArgumentoInvalido;
import com.unibratec.info.tiposgerais.Colecao;
import com.unibratec.usuario.excecoes.ExcecaoUsuarioInexistente;
import com.unibratec.usuario.excecoes.ExcecaoUsuarioInvalido;
import com.unibratec.usuario.excecoes.ExcecaoUsuarioJaExistente;

/**
 * @author manha
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class CadastroUsuario {
	private IRepositorioUsuario repositorio;
	
	/**
	 * @param repositorio
	 */
	public CadastroUsuario(IRepositorioUsuario repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	
	public void incluir(Usuario usuario) throws ExcecaoUsuarioJaExistente, ExcecaoUsuarioInvalido,ExcecaoAcessoBD{
		  repositorio.incluir(usuario);
	}

	public void excluir(String login) throws ExcecaoUsuarioInexistente, ExcecaoArgumentoInvalido,ExcecaoAcessoBD{
		repositorio.excluir(login);
	}
	
	public void alterar(Usuario usuario) throws ExcecaoUsuarioInexistente, ExcecaoUsuarioInvalido,ExcecaoAcessoBD{
		repositorio.alterar(usuario);
	}
	
	public boolean consultar(String login) throws ExcecaoArgumentoInvalido,ExcecaoAcessoBD{
		return repositorio.consultar(login);
	}
	public Usuario buscar(String login) throws ExcecaoUsuarioInexistente, ExcecaoArgumentoInvalido,ExcecaoAcessoBD{
		return repositorio.buscar(login);
	}

	public Colecao elementos() throws ExcecaoAcessoBD{
		return repositorio.colecao();
	}
	
	public boolean autenticaUsuario(String login, String senha) throws ExcecaoUsuarioInexistente, ExcecaoArgumentoInvalido,ExcecaoAcessoBD {
		Usuario us = repositorio.buscar(login);
		return us.validaSenha(senha);
		
	}
}
