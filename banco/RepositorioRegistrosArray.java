package banco;

import AgendaEletronica.Registro;

public class RepositorioRegistrosArray implements RepositorioRegistro {
	private Registro[] repositorio = new Registro[100];

	private int indice = 0;

	public int procurarIndice(String numero) {
		return 0;
	}

	public void inserir(Registro novoRegistro) {
		repositorio[indice] = novoRegistro;
		indice++;
	}

	public void remover(String nome) {
		for (int i = 0; i < indice; i++) {
			if (repositorio[i].getNome().equals(nome)) {
				// ACHOU, DELETA
				// roda os numeros diminuindo-os
				int z=i;
				while (z+1<indice) {
						repositorio[i] = repositorio[i + 1];
						z++;
			}
				// move os espaços
				indice--;
			}

		}

	}

	public Registro procurar(String nome) {
		for (int i = 0; i < indice; i++) {
			Registro aux = repositorio[i];
			if (aux.getNome().equals(nome)) {
				return aux;
			}
		}

		return null;
	}
	public boolean existe(String nome) {
		for (int i=0;i< indice;i++) {
			if (repositorio[i].getNome().equals(nome)) {
			return false;
			}
		}
		return true;
	}
	

}
