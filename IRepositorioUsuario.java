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
public interface IRepositorioUsuario {
	public void incluir(Usuario usuario) throws ExcecaoUsuarioJaExistente, ExcecaoUsuarioInvalido, RepositorioException;
	public void excluir(String login) throws ExcecaoUsuarioInexistente, ExcecaoArgumentoInvalido, RepositorioException;
	public void alterar(Usuario usuario) throws ExcecaoUsuarioInexistente, ExcecaoUsuarioInvalido, RepositorioException;
	public boolean consultar(String login) throws ExcecaoArgumentoInvalido, RepositorioException;
	public Usuario buscar(String login) throws ExcecaoUsuarioInexistente, ExcecaoArgumentoInvalido, RepositorioException;
	public Colecao colecao() throws RepositorioException;
}
