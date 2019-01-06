package core.streams.parallel.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsParallelos {
	public static void main(String[] args) {
		long num = 18_000_000_0;
		
		somaFor(num);
		//somaStreamsSequencial(num);
		//somaStreamsParallel(num);
		somaStreamsParallelRangeClosed(num);
		
		// descobrir o numero de processadores
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
	
	// usando um for tradicional
	private  static void somaFor(long num) {
		System.out.println("Somando com FOR");
		long result = 0l;
		long init = System.currentTimeMillis(); // marca o tempo inicial
		for (long i= 1l; i <= num; i++) {
			result += i; 
		}
		long fim = System.currentTimeMillis(); // marca tempo final
		System.out.printf("resultado : %d  - tempo %d ms\n",result,(fim-init));
	}
	
	// usando um Streams Sequencial
	private  static void somaStreamsSequencial(long num) {
		System.out.println("Somando com Streams Sequencial");
		long result = 0l;
		long init = System.currentTimeMillis(); // marca o tempo inicial
        result = Stream.iterate(1L, i-> i +1)
        		       .limit(num)
        		       .reduce(0l,Long::sum);
		long fim = System.currentTimeMillis(); // marca tempo final
		System.out.printf("resultado : %d  - tempo %d ms\n",result,(fim-init));
	}
	
	// usando um Streams Paralelos
	// devido iteracao sequencial na formacao dos numeros, ao unboxing, preparacao das threads, reduce, este é o pior resultado
	private  static void somaStreamsParallel(long num) {
		System.out.println("Somando com Streams Paralelos");
		long result = 0l;
		long init = System.currentTimeMillis(); // marca o tempo inicial
        result = Stream.iterate(1L, i-> i +1)
				       .limit(num)
				       .parallel() 
        		       .reduce(0L,Long::sum);
		long fim = System.currentTimeMillis(); // marca tempo final
		System.out.printf("resultado : %d  - tempo %d ms\n",result,(fim-init));
	}
	
	// usando um Streams Paralelos com LongStream.RangeClosed
	// este terá a melhor performance conforme o numero aumente
	// 18_000_000_0 até este valor o FOR teve melhor performance 
	private  static void somaStreamsParallelRangeClosed(long num) {
		System.out.println("Somando com LongStream Paralelos e RangeClosed");
		long result = 0l;
		long init = System.currentTimeMillis(); // marca o tempo inicial
        result = LongStream.rangeClosed(1l, num)
				       .parallel() 
        		       .reduce(0l,Long::sum);
		long fim = System.currentTimeMillis(); // marca tempo final
		System.out.printf("resultado : %d  - tempo %d ms\n",result,(fim-init));
	}
}
