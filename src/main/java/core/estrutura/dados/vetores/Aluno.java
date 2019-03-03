package core.estrutura.dados.vetores;

public class Aluno {
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Aluno(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "nome=" + nome ;
	}
	
	
}
