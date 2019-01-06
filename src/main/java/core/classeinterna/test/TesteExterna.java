package core.classeinterna.test;

public class TesteExterna {
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// regras
	// 1- para acessar uma classe interna tem que ter um objeto da classe externa
	// 2- A classe interna tem acesso a todos os métodos e atributos da classe externa
	// escopos da classe interna: private, public, protected, static, strictfp
	class Interna {
		public void imprimir() {
			System.out.println("imprimir nome: " + ((nome != null ) ? nome : "Sem Nome"));
			
			System.out.println("this da classe interna: " + this);
			System.out.println("this da classe externa: " + TesteExterna.this);
		}
		
		public void setNome(String nome) {
			TesteExterna.this.nome = nome; // referência ao this da classe externa
		}
	}
	public static void main(String[] args) {
		TesteExterna externa = new TesteExterna();
		
		// para criar a classe interna
		// Método 1 - com uma variavel de instancia da classe externa.
		TesteExterna.Interna interna = externa.new Interna();
		
		// Método 2 - sem uma variavel de instancia da classe externa.
		TesteExterna.Interna interna2 = new TesteExterna().new Interna();
		externa.setNome("Sergio");
		
		interna.imprimir();
		interna2.setNome("sergio Lima");
		interna2.imprimir();
		
		
	}
}
