package Entitites;

public class Contato {
	
	private String nome;
	private String email;
	private Long numero;
	
	public Contato() {
	}

	public Contato(String nome, String email, Long numero) {
		this.nome = nome;
		this.email = email;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Nome = " + nome + "\nEmail = " + email + "\nNúmero = " + numero + "\n";
	}

}