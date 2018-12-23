package core.serializacao.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Aluno implements Serializable {

	// private static final long serialVersionUID = 123L;
	private Long id;
	private String nome;
	private Integer idade;
	private transient String senha; // nao sera serializado
	private static String escola = "DevDojo";
	private transient int media;
	private transient Turma turma; // seta como transient para o java ignorar na serializacao normal
	                               // implementa metodos writeObject e readObject para uma serializacao
	                               // controlada.

	public Aluno(Long id, String nome, Integer idade, String senha, int media, Turma turma) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.senha = senha;
		this.turma = turma;
		this.media = media;
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

	private String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public int getMedia() {
		return media;
	}
	
	public void setMedia(int media) {
		this.media = media;
	}

	/*
	 * metodo necessario para serializacao de um objeto associado a classe
	 * se classe associada nao implementar Serializable
	 */
	private void writeObject(ObjectOutputStream oos) {
		try {
			System.out.println("==================================");
			System.out.println("Serializacao do objeto turma");
			System.out.println("==================================");
			System.out.println();
			oos.defaultWriteObject();        // a ordem destes metodos nao sao importantes
			oos.writeUTF(turma.getNome());   // mas tem que seguir a mesma sequencia na desserializacao
			oos.writeInt(media);  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Desserializacao do objeto - os metodos devem seguir mesma ordem implementada no writeObject
	 */
	private void readObject(ObjectInputStream ois) {
		try {
			System.out.println();
			System.out.println("==================================");
			System.out.println("Desserializacao do objeto turma");
			System.out.println("==================================");
			System.out.println();
			ois.defaultReadObject();
			turma = new Turma(ois.readUTF());
			media = ois.readInt();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", idade=" + idade + ", escola=" + escola + ", senha=" + senha
				+ ", media=" + media 
				+ ", turma=" + turma + "]";
	}

}
