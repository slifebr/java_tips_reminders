package core.estrutura.dados.vetores;

public class AlunoVetorTeste {

	public static void main(String[] args) {

		Aluno a1 = new Aluno("Aluno1");
		Aluno a2 = new Aluno("Aluno2");
		Aluno a3 = new Aluno("Aluno3");
		Aluno a4 = new Aluno("Aluno4");
		Aluno a5 = new Aluno("Aluno5");
		Aluno a6 = new Aluno("Aluno6");
		Aluno a7 = new Aluno("Aluno7");
		Aluno a8 = new Aluno("Aluno8");
		Aluno a9 = new Aluno("Aluno9");

		AlunoVetor vetor = new AlunoVetor(2);

		vetor.adiciona(a1);
		vetor.adiciona(a2);
		vetor.adiciona(a3);
		vetor.adiciona(a4);
		vetor.adiciona(a5);
		vetor.adiciona(a6);
		vetor.adiciona(a7);
		vetor.adiciona(a8);
		vetor.adiciona(a9);

		System.out.println(vetor);

		System.out.println("tamanho: " + vetor.tamanho());
		System.out.println("length: " + vetor.length());

	}

}
