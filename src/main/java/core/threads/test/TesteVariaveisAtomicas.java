package core.threads.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import core.threads.classes.Contador;
import core.threads.classes.IncrementadorThread;

public class TesteVariaveisAtomicas {



	public static void main(String[] args) throws InterruptedException {
		Contador c = new Contador();

		IncrementadorThread it1 = new IncrementadorThread(c);
		IncrementadorThread it2 = new IncrementadorThread(c);
		IncrementadorThread it3 = new IncrementadorThread(c);

		it1.start();
		it2.start();
		it3.start();
		it1.join();
		it2.join();		
		it3.join();		

		System.out.println("Thread normal com synchronized: " + c.getCount());
		System.out.println("Variavel atomica sem ExecutorService: " + c.getAtomicInteger());
		System.out.println("Variavel atomica com ExecutorService: " + c.getAtomicIntegerWithExecutorService());
		
		it1.runWithExcutor();
		System.out.println("Variavel atomica com ExecutorService2: " + c.getAtomicIntegerWithExecutorService());
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		c.incrementWithExecutor(executor, 1000);
		c.stop(executor);
		System.out.println("Variavel atomica com ExecutorService3: " + c.getAtomicIntegerWithExecutorService());
	
		// resultados obtidos	
		/*
		dentro ExecutorService: 8053
		dentro ExecutorService: 12470
		dentro ExecutorService: 16375
		Thread normal com synchronized: 30000
		Variavel atomica sem ExecutorService: 30000
		Variavel atomica com ExecutorService: 30000
		dentro ExecutorService: 5916
		Variavel atomica com ExecutorService2: 10000
		dentro ExecutorService: 4867
		Variavel atomica com ExecutorService3: 10000
		 */
	}
}
