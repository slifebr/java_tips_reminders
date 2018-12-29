package core.threads.classes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IncrementadorThread extends Thread {

	private Contador contador;
    private int num = 10000;
    
	public IncrementadorThread(Contador contador) {
		this.contador = contador;
	}

	public void run() {
		
		for (int i = 0; i < num; i++) {
			contador.increment();
			contador.incrementSynchronized();
		}
		 runWithExcutor() ;
	}

	public void runWithExcutor() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		contador.incrementWithExecutor(executor, num);
		contador.stop(executor);
	}
}
