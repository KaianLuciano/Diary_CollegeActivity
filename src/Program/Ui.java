package Program;

import java.util.Scanner;

import Entitites.Agenda;
import Entitites.Contato;

public class Ui {

	private Scanner scanner = new Scanner(System.in);
	private Agenda agenda = new Agenda();
	
	public void mostrarOpcoes() {
		int escolhaUsuario = 0;
		do {
			int escolhaDoUsuario = 0;
			System.out.println("\nOque deseja fazer ? \n\n1)Mostrar Lista \n2)Inserir um novo contato\n3)Remover um contato\n4)Atualizar um contato");
			escolhaDoUsuario = scanner.nextInt();
			
			switch (escolhaDoUsuario) {
			case (1):
				mostrarLista();
				break;
			case (2):
				inserir();
				break;
			case (3):
				remover();
				break;
			case (4):
				atualizar();
				break;
			default:
				System.out.println("Opção digitada não existe");
			}
			System.out.println("Deseja continuar ? (Sim 1 : Não 2)");
			escolhaUsuario = scanner.nextInt();
		}while(escolhaUsuario == 1);
		
		scanner.close();
	}
	
	public void mostrarLista() {
		if(agenda.getContatos().isEmpty()) {
			System.out.println("Lista Vazia!");
			return;
		}
		System.out.println(agenda.getContatos());
	}
	
	public void inserir() {
		String nome, email, numero;
		
		System.out.println("Insira o nome do contato");
		scanner.nextLine();
		nome = scanner.nextLine();
		
		System.out.println("Insira o email do contato");
		email = scanner.nextLine();
		
		System.out.println("Digite o número do usuário");
		numero = scanner.nextLine();
		numero = numero.replaceAll(" ", "");
		
		if(agenda.verificarTamanhoNumero(numero)) {
			System.out.println("Número inserido não segue o padrão permitido de 11 números (DD) XXXXX-XXXX");
			return;
		}
		
		if(!agenda.verificarSePossuiSomenteNumero(numero)) {
			System.out.println("São permitidos somente números");
			return;
		}
		
		agenda.inserir(new Contato(nome, email, Long.parseLong(numero)));
		
		if(!agenda.getContatos().isEmpty()) {
			System.out.println("\nLista Atualizada: ");
			System.out.println(agenda.getContatos());
		}
		else {
			System.out.println("Lista vazia");
		}
	}
	
	public void atualizar() {
		if(agenda.getContatos().isEmpty()) {
			System.out.println("Lista Vazia");
			return;
		}
		
		String nomeAntigo, nomeAtualizado, email, numero;
		System.out.println("\nLista Atualizada: ");
		System.out.println(agenda.getContatos());
		
		System.out.println("Nome do contato a ser atualizado:");
		scanner.nextLine();
		nomeAntigo = scanner.nextLine();		
		
		if(agenda.verificar(nomeAntigo) == true) {
		System.out.print("Digite os seguintes dados para atualizar o contato: \nNome: ");
		nomeAtualizado = scanner.nextLine();
		System.out.print("Email: ");
		email = scanner.next();
		System.out.print("Número: ");
		scanner.nextLine();
		numero = scanner.nextLine();
		numero = numero.replaceAll(" ", "");
		
		if(agenda.verificarTamanhoNumero(numero)) {
			System.out.println("Número inserido não segue o padrão permitido de 11 números (DD) XXXXX-XXXX");
			return;
		}
		
		if(!agenda.verificarSePossuiSomenteNumero(numero)) {
			System.out.println("São permitidos somente números");
			return;
		}
		
		agenda.atualizar(nomeAntigo, new Contato(nomeAtualizado, email, Long.parseLong(numero)));
		
		System.out.println("Lista atualizada:\n");
		System.out.println(agenda.getContatos());
		}
		else {
			System.out.println("Contato inserido não existe");
		}
	}
	
	public void remover() {
		if(agenda.getContatos().isEmpty()) {
			System.out.println("Lista Vazia");
			return;
		}
		String nome;
		System.out.println("Contatos existentes: ");
		System.out.println(agenda.getContatos());
		System.out.println("Digite o nome do usuário a ser deletado: ");
		scanner.nextLine();
		nome = scanner.nextLine();
		
		agenda.remover(nome);
	}
}