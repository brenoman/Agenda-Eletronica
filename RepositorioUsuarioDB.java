/*
 * Created on 30/11/2005
 * 
 * To change the template for this generated file go to Window - Preferences -
 * Java - Code Generation - Code and Comments
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * @author manha
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class RepositorioUsuarioDB implements IRepositorioUsuario {

	private static RepositorioUsuarioDB instancia = null;

	public RepositorioUsuarioDB() {
	}

	public synchronized static RepositorioUsuarioDB obterInstancia() {
		if (instancia == null) {
			instancia = new RepositorioUsuarioDB();
		}
		return instancia;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.unibratec.dal.IRepositorioUsuario#incluir(com.unibratec.info.usuarios.Usuario)
	 */
	public void incluir(Usuario usuario)
		throws ExcecaoUsuarioJaExistente, ExcecaoUsuarioInvalido, RepositorioException {
		System.out.println("Chega aki???");
		try {
			Statement statement = Conector.reservaStatement();
			if (usuario != null) {
				try {
					try {
						if (!consultar(usuario.getLogin())) {
							//System.out.println("Parte 1");
							statement.executeUpdate(
									"INSERT INTO USUARIO VALUES ("
									+ "'"  + usuario.getLogin()  + "'"
									+ ",'" + usuario.getSenha()  + "'"
									+ ",'" + usuario.isSituacao()+ "')");
						}
					} catch (ExcecaoArgumentoInvalido e) {
						e.printStackTrace();
					}
				}catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			Conector.liberaStatement();

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.unibratec.dal.IRepositorioUsuario#excluir(java.lang.String)
	 */
	public void excluir(String login)
		throws ExcecaoUsuarioInexistente, ExcecaoArgumentoInvalido, RepositorioException {
		try {
			Statement stat = Conector.reservaStatement();
			if (!login.equals("")) {
				try {
					int linhas =
						stat.executeUpdate(
							"DELETE FROM usuario WHERE NOME = '" + login + "'");
					if (!(linhas > 0)) {
						try {
							throw new ExcecaoUsuarioInexistente();
						} catch (ExcecaoUsuarioInexistente e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (SQLException ex) {
					try {
						throw new RepositorioException(ex);
					} catch (RepositorioException e) {
						e.printStackTrace();
					}
				}
			}
		} finally {
			Conector.liberaStatement();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.unibratec.dal.IRepositorioUsuario#alterar(com.unibratec.info.usuarios.Usuario)
	 */
	public void alterar(Usuario usuario)
			throws ExcecaoUsuarioInexistente, ExcecaoUsuarioInvalido {
		int resultado = 0;
		try {
			Statement statement = Conector.reservaStatement();
			if (usuario != null) {
				if (usuario.isSituacao() == true){
					resultado =
						statement.executeUpdate(
						"UPDATE usuario SET NOME = '"
						+ usuario.getLogin()
						+ "'"
						+ ", SENHA = '"
						+ usuario.getSenha()
						+ "'"
						+ ", SITUACAO = ''A''");
					if (resultado == 0) {
						throw new ExcecaoUsuarioInexistente();
					} else {
						resultado =
						statement.executeUpdate(
						"UPDATE usuario SET NOME = '"
						+ usuario.getLogin()
						+ "'"
						+ ", SENHA = '"
						+ usuario.getSenha()
						+ "'"
						+ ", SITUACAO = ''I''");
						if (resultado == 0) {
							throw new ExcecaoUsuarioInexistente();
						}
					}
				}
			}
		}catch(Throwable ex ){
			//
		}
		finally {
			Conector.liberaStatement();
		}
	}

/*
 * (non-Javadoc)
 * 
 * @see com.unibratec.dal.IRepositorioUsuario#consultar(java.lang.String)
 */
	public boolean consultar(String login) throws ExcecaoArgumentoInvalido, RepositorioException {
		boolean resposta = false;
		try {
			Statement statement = Conector.reservaStatement();
			ResultSet resultset = statement.executeQuery(
					"SELECT * FROM USUARIO WHERE NOME = '" + login + "'");
			resposta = resultset.next();
			resultset.close();
		}
		catch (SQLException e) {
			//
		}
		finally {
			Conector.liberaStatement();
		}
		return resposta;
	}

/*
 * (non-Javadoc)
 * 
 * @see com.unibratec.dal.IRepositorioUsuario#buscar(java.lang.String)
 */
public Usuario buscar(String login)
	throws ExcecaoUsuarioInexistente, ExcecaoArgumentoInvalido, RepositorioException {
	Usuario usuario = null;
	
	try {
		Statement statement = Conector.reservaStatement();
		ResultSet resultset = statement.executeQuery(
				"SELECT * FROM USUARIO WHERE NOME = '" + login + "'");
		resultset.next();
		String nome = resultset.getString("NOME");
		String senha = resultset.getString("SENHA");
		String situacao = resultset.getString("SITUACAO");
		
		boolean realSituacao = false;
		if(situacao.equals("A")){
			realSituacao = true;
		}
		usuario = new Usuario(nome,senha,realSituacao);
		resultset.close();
	}
	catch (SQLException e) {
		//
	}
	finally {
		Conector.liberaStatement();
	}
	return usuario; 
}

/*
 * (non-Javadoc)
 * 
 * @see com.unibratec.dal.IRepositorioUsuario#colecao()
 */
	public Colecao colecao() throws RepositorioException {
		boolean resposta = false;
		Usuario usuario = null;
		boolean realSituacao = false;
		Colecao colecao  = new Colecao();
	
		try {
			Statement statement = Conector.reservaStatement();
	
			ResultSet resultset = statement.executeQuery(
			"SELECT * FROM USUARIO");
			while(resultset.next()){
				String nome = resultset.getString("NOME");
				String senha = resultset.getString("SENHA");
				String situacao = resultset.getString("SITUACAO");

				if(situacao.equals("A")){
					realSituacao = true;
				}
				usuario = new Usuario(nome,senha,realSituacao);
			
				try {
					usuario.setLogin(nome);
				} catch (ExcecaoLoginInvalido e1) {
					e1.printStackTrace();
				}
				try {
					usuario.setSenha(senha);
				} catch (ExcecaoSenhaInvalida e2) {
					e2.printStackTrace();
				}
				usuario.setSituacao(realSituacao);
			
				colecao.inclui(usuario);
			}
		}
		catch (SQLException e) {
			try {
				throw new RepositorioException(e);
			} catch (RepositorioException e1) {
				e1.printStackTrace();
			}
		}
		finally {
			Conector.liberaStatement();
		};
	return colecao;
	}
}

