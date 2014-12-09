package AgendaEletronica;
public class Registro {
	private String nome;
	private String telefone;
	private String celular;
	private String observacoes;
	public Registro (String novoNome,String novoTelefone,String novoCelular, String novaObservacao) {
		setNome(novoNome);
		setTelefone(novoTelefone);
		setCelular(novoCelular);
		setObservacoes(novaObservacao);
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
