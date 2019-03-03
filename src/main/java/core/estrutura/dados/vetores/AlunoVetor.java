package core.estrutura.dados.vetores;

import java.util.Arrays;

public class AlunoVetor {

	private Aluno[] alunos;
    private int tamanho;
    
	public AlunoVetor(int tamanhoVetor) {
		this.alunos = new Aluno[tamanhoVetor];
	}
	
	private void expandeVetorComCopia() {
		Aluno[] aux = new Aluno[this.alunos.length * 2];
		copiaVetor(this.alunos, aux);
		this.alunos = new Aluno[aux.length];
		copiaVetor(aux, this.alunos);
	}
	
	
	private void expandeVetor() {
		Aluno[] aux = new Aluno[this.alunos.length * 2];
		System.arraycopy(this.alunos, 0, aux, 0, this.alunos.length);
		this.alunos = new Aluno[aux.length];
		System.arraycopy(aux, 0,  this.alunos, 0, aux.length); //possui performance melhor
		//this.alunos = Arrays.copyOf(aux, aux.length);
	}
	
	private void copiaVetor(Aluno[] origem, Aluno[] destino) {
		for (int i =0; i< origem.length;i++) {
			
			if (origem[i] == null) 	break;
			
			destino[i] = origem[i];
		}
	}

	public void adiciona(Aluno aluno) {
		if(this.alunos.length == this.tamanho) {
			expandeVetor();
			//expandeVetorComCopia();
		}
         this.alunos[this.tamanho] = aluno;
         this.tamanho++;
//		for (int i = 0; i < this.alunos.length - 1; i++) {
//			if (this.alunos[i] == null) {
//				this.alunos[i] = aluno;
//				break;
//			}
//		}
	}

	public void adiciona(int posicao, Aluno aluno) {

	}

	public Aluno pega(int posicao) {
		return null;
	}

	public void remove(int posicao) {

	}

	public boolean contem(Aluno aluno) {
		return false;
	}

	public int tamanho() {
		return this.tamanho;
	}

	public int length() {
		return this.alunos.length;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		String pipe = "";
		for (Aluno aluno : alunos) {
			if (aluno != null) {
				sb.append(pipe);
				sb.append(aluno.toString());
				pipe = ",";
			} else
				break;
		}
		// return Arrays.toString(alunos) ;
		sb.append("]");
		return sb.toString();
	}
}
