package EstruturaDeDados;

import Entitites.Contato;

public class ListaEncadeada <T>{

private No<T> referenciaEntrada;
	
	public ListaEncadeada() {
		referenciaEntrada = null;
	}
	
	public Contato get(int index) {
		return getNo(index).getDados();
	}
	
	private No<T> getNo(int index) {
		validaIndice(index);
		No<T> noAuxiliar = referenciaEntrada;
		No<T> noRetorno = null;
		
		for(int i = 0; i <= index;i++) {
			noRetorno = noAuxiliar;
			noAuxiliar = noAuxiliar.getproximoNo();
		}
		
		return noRetorno;
	}
	
	public Contato remove(int index) {
		
		No<T> noPivor = getNo(index);
		if(index == 0) {
			referenciaEntrada = noPivor.getproximoNo();
			return noPivor.getDados();
		}
		
		No<T> noAnterior = getNo(index-1);
		noAnterior.setproximoNo(noPivor.getproximoNo());
		return noPivor.getDados();
	}
	
	public void add(Contato conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		
		if(isEmpty()) {
			referenciaEntrada = novoNo;
			return;
		}
		
		No<T> noAuxiliar = referenciaEntrada;
		for(int contador = 0; contador < this.size()-1; contador++) {
			noAuxiliar = noAuxiliar.getproximoNo();
		}
		
		noAuxiliar.setproximoNo(novoNo);
		
	}
	
	public int size() {
		int tamanhoLista = 0;
		No<T> referenciaAux = referenciaEntrada;
		
		while(true) {
			if(referenciaAux != null) {
				tamanhoLista++;
				if(referenciaAux.getproximoNo() != null) {
					referenciaAux = referenciaAux.getproximoNo();
				}
				else {
					break;
				}
			}
			else {
				break;
			}
		}
		
		return tamanhoLista;
	}
	
	public boolean isEmpty() {
		return referenciaEntrada == null ? true : false;
	}
	
	private void validaIndice(int index) {
		if(index >= size()) {
			int ultimoIndice = size()-1;
			throw new IndexOutOfBoundsException("Não existe conteudo no indece " + index + " desta lista. Esta lista so vai até o indice " + ultimoIndice);
		}
	}

	@Override
	public String toString() {
		String strRetorno = "";
		No<T> noAuxiliar = referenciaEntrada;
		for(int contador = 0; contador < size(); contador++) {
			strRetorno += noAuxiliar.getDados();
			noAuxiliar = noAuxiliar.getproximoNo();
		}
		return strRetorno;
	}
	
}
