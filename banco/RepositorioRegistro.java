package banco;

import AgendaEletronica.Registro;

/*
 * Created on 01/09/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author bjrv
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface RepositorioRegistro {
	
	public int procurarIndice(String numero) ;
	public void inserir(Registro novoRegistro);
	public void remover(String nome);
	public Registro procurar(String nome) ;

}
