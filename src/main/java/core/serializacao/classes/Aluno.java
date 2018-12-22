package core.serializacao.classes;

import java.io.Serializable;

public class Aluno implements Serializable{

	private static final long serialVersionUID = 123L;
	private Long id;
	private String nome;
	private Integer idade;
	private static String escola = "DevDojo";
	
	public Aluno(Long id, String nome, Integer idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public static String getEscola() {
		return escola;
	}
	public static void setEscola(String escola) {
		Aluno.escola = escola;
	}
	
	
	@Override
	public String toString() {
		return "Aluno [id=" + id + 
			   ", nome=" + nome + 
			   ", idade=" + idade +
			   ", escola=" + escola + "]";
	}

	
	
	
}
