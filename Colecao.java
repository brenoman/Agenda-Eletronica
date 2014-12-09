/*
 * Created on 15/08/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

import java.util.ArrayList;


/**
 * @author manha
 * 
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Colecao {
	private ArrayList colecao;
		
	/**
	 * @param colecao
	 */
	public Colecao() {
		super();
		this.colecao = new ArrayList();
	}

	public void inclui(Object obj) {
		colecao.add(obj);
	}

	public void exclui(Object obj) {
		colecao.remove(obj);
	}

	
	public Object busca(int posicao) {
		return colecao.get(posicao);
	}

	public int tamanho() {
		return colecao.size();
	}
	
	
	public String toString() {
		String retorno = "[";
		for (int i = 0; i < colecao.size(); i++) {
			retorno = retorno + colecao.get(i).toString();
			if (i < colecao.size()-1) {
				retorno = retorno + ",";
			} else {
				retorno = retorno + "]";
			}
			
		}
		return retorno;
	}
	
}
