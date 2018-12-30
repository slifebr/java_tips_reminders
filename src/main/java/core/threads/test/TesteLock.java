package core.threads.test;

import java.util.concurrent.locks.ReentrantLock;

public class TesteLock {

	public static void main(String[] args) {
		final ReentrantLock lock = new ReentrantLock();
		new Thread(new Worker("A", lock)).start();
		new Thread(new Worker("B", lock)).start();
		new Thread(new Worker("C", lock)).start();
		new Thread(new Worker("D", lock)).start();
		new Thread(new Worker("E", lock)).start();

	}
	
	static class Worker implements Runnable{

		private String nome; // nome da thread
		private ReentrantLock reentrantLock;
		
		
		public Worker(String nome, ReentrantLock reentrantLock) {
			this.nome = nome;
			this.reentrantLock = reentrantLock;
		}


		@Override
		public void run() {
			reentrantLock.lock();
			
			try {
				
				if(reentrantLock.isHeldByCurrentThread()) 
					System.out.printf("Thread %s entrou em uma sessao critica%n ",nome );
				
				System.out.printf("%d Threads esperando na fila%n", reentrantLock.getQueueLength());
				System.out.printf("Threads %s vai trabalhar por dois segundos%n", nome);
				Thread.sleep(2000);
				System.out.printf("Threads %s  finalizou%n", nome);
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				reentrantLock.unlock();
			}
		}
		
	}

}
