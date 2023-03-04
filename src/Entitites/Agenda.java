package Entitites;

import java.text.Normalizer;
import java.util.regex.Pattern;

import EstruturaDeDados.ListaEncadeada;

public class Agenda {

	private ListaEncadeada<Contato> contatos = new ListaEncadeada<>();
	
	public ListaEncadeada<Contato> getContatos() {
		return contatos;
	}

	public void inserir(Contato contato) {
		contatos.add(contato);
	}
	
	public void remover(String nomeContato) {
		if(contatos.isEmpty()) {
			throw new RuntimeException("Lista Vazia");
		}
		
		for(int contador = 0; contador < contatos.size(); contador++) {
			String contatoAtual = removerAcentos(contatos.get(contador).getNome());
			String contatoRecebido = removerAcentos(nomeContato);
			
			if(contatoAtual.equalsIgnoreCase(contatoRecebido)) {
				contatos.remove(contador);
				System.out.println("Contato Excluido");
				return;
			}
		}
	}
	
	public void atualizar(String nomeContato, Contato contato) {
		if(contatos.isEmpty()) {
			throw new RuntimeException("Lista Vazia");
		}

		int validacao = 0;
		for(int contador = 0; contador < contatos.size(); contador++) {
			String contatoAtual = removerAcentos(contatos.get(contador).getNome());
			String contatoRecebido = removerAcentos(nomeContato);
			
			if(contatoAtual.equalsIgnoreCase(contatoRecebido)) {
				atualizar(contato, contador);
				validacao++;
			}
			
			if(validacao == 1) {
				System.out.println("Contato Atualizado\n");
				return;
			}
		}
		
		if(validacao == 0) {
			System.out.println("Contato não encontrado, confira o nome e tente novamente.");
		}
	}
	
	private void atualizar(Contato contato, int posicao) {
		contatos.get(posicao).setEmail(contato.getEmail());
		contatos.get(posicao).setNumero(contato.getNumero());
		contatos.get(posicao).setNome(contato.getNome());

	}
	
	public boolean verificar(String nomeContato) {
		for(int contador = 0; contador < contatos.size(); contador++) {
			String contatoAtual = removerAcentos(contatos.get(contador).getNome());
			String contatoRecebido = removerAcentos(nomeContato);
			
			if(contatoAtual.equalsIgnoreCase(contatoRecebido)) {
				return true;
			}
			
		}
		return false;
	}
	
	public boolean verificarTamanhoNumero(String numero) {
		if (numero.length() > 11 || numero.length() < 11){
		      return true;
		   }else{
		      return false;
		   }
	}
	
	public boolean verificarSePossuiSomenteNumero(String numero) {
		return numero.matches("[0-9]+");
	}
	
	private  String removerAcentos(String value) {
        String normalizador = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizador).replaceAll("");
	}
	
}