package EstruturaDeDados;

import Entitites.Contato;

public class No<T> { 
	
	private Contato conteudo;
	private No<T> proximoNo;

	public No() {
		this.proximoNo = null;
	}

	public No(Contato conteudo) {
		this.conteudo = conteudo;
		proximoNo = null;
	}

	public No(Contato conteudo, No<T> proximoNo) {
		this.conteudo = conteudo;
		this.proximoNo = proximoNo;
	}

	public Contato getDados() {
		return conteudo;
	}

	public void setDados(Contato conteudo) {
		this.conteudo = conteudo;
	}

	public No<T> getproximoNo() {
		return proximoNo;
	}

	public void setproximoNo(No<T> proximoNo) {
		this.proximoNo = proximoNo;
	}

	@Override
	public String toString() {
		return "Nome: " + conteudo.getNome() + "\nEmail: " + "\nNúmeros: " + conteudo.getNumero();
	}
	
}
