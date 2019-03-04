package core.estrutura.dados.vetores;

import java.util.Date;

public class NumeroVetorTeste {

	public static void main(String[] args) {
		NumeroVetor vetor = new NumeroVetor(4);
		long start;
		long fim ;
		long millis;
		
		vetor.adiciona(10);
		vetor.adiciona(7);
		vetor.adiciona(4);
		vetor.adiciona(8);
		vetor.adiciona(2);
		vetor.adiciona(1);
        //vetor.sort();
		System.out.println("array não ordenado");
		System.out.println(vetor + " Tamanho Vetor: " + vetor.getTamanho());
		
		// O jeito mais facil seria inserir em qualquer posicao e reordenar
		start = System.currentTimeMillis();
		vetor.adicionaEntreMaiorMenorComFor(12);
		fim = System.currentTimeMillis();
		millis = (fim - start);
		System.out.println("tempo(adicionaEntreMaiorMenorComFor      ):" + fim + " / "+ start);
		System.out.println(vetor + " Tamanho Vetor: " + vetor.getTamanho());
		
		start = System.currentTimeMillis();
		vetor.adicionaEntreMaiorMenorComFor(0);
		fim = System.currentTimeMillis();
		millis = (fim - start);
		System.out.println("tempo(adicionaEntreMaiorMenorComFor):" + fim + " / "+ start);
		System.out.println(vetor + " Tamanho Vetor: " + vetor.getTamanho());
		
		start = System.currentTimeMillis();
		vetor.adicionaEntreMaiorMenorComFor(5);
		fim = System.currentTimeMillis();
		millis = (fim - start);
		System.out.println("tempo(adicionaEntreMaiorMenorComFor):" + fim + " / "+ start);
		
		System.out.println("==================================");
		System.out.println(vetor + " Tamanho Vetor: " + vetor.getTamanho());
		
	}

}
