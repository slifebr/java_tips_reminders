package core.estrutura.dados.vetores;

import java.util.Date;

public class NumeroVetorTeste {

	public static void main(String[] args) {
		NumeroVetor vetor = new NumeroVetor(4);
		vetor.adiciona(10);
		vetor.adiciona(7);
		vetor.adiciona(4);
		vetor.adiciona(8);
		vetor.adiciona(2);
		vetor.adiciona(1);
        //vetor.sort();
		// array não ordenado
		System.out.println(vetor + " Tamanho Vetor: " + vetor.getTamanho());
		
		// O jeito mais facil seria inserir em qualquer posicao e reordenar
		long start = System.currentTimeMillis();
		vetor.adicionaEntreMaiorMenor(12);
		long fim = System.currentTimeMillis();
		long millis = (fim - start);
		System.out.println("tempo(adicionaEntreMaiorMenor      ):" + fim + " / "+ start);

		start = System.currentTimeMillis();
		vetor.adicionaEntreMaiorMenorComFor(0);
		fim = System.currentTimeMillis();
		millis = (fim - start);
		
		System.out.println("tempo(adicionaEntreMaiorMenorComFor):" + fim + " / "+ start);
		System.out.println("==================================");
		System.out.println(vetor + " Tamanho Vetor: " + vetor.getTamanho());
		
	}

}
