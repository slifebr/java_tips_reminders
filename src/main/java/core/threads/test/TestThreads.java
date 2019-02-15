package core.threads.test;
/*
 * 2 tipos?
 * 	daemon - exemplo: garbage collection
 *  user - o sistema somente encerra qdo tods threads user encerram 
 *  
 *  threads não podem ser startadas mais que uma vez
 *  ====================
 *  states:
 *                      | Waiting/Blocking/sleep |
 *                      --------------------------
 *                          |      /|\
 *                         \|/      |
 *           New -> Runnable <-> Running -> Dead
 *           
 *           New = qdo cria a thread (criada mas não está viva)
 *           Runnable = qdo da o start(), libera para o schedule ativa-la( não  significa que está rodando/ativa)
 *           Running = qdo o schedule ativa a thread e ela se torna um processo em execução
 *           Waiting/Blocking/sleep = após o running fica alternando pelo schedule fazendo um ciclo até o termino
 *           Waiting/Blocking/sleep podem ser controlados desenvolvedor ou por sistema de terceiros ou mesmo jvm
 *           exemplo: o carregamento de um arquivo pesado pode por a thread em bloqueio.
 *           após o termino de Waiting/Blocking/sleep, ela volta para Runnable para aguardar o schedule.
 *           
 *           Uma thread não pode alterar o status de outra thread (antes era permitido, mas estes metodos foram depreciados)  
 *           
 */

import org.bushe.swing.event.ThreadSafeEventService;

class ThreadExemplo extends Thread{
	private char c;

	public ThreadExemplo(char c) {
		this.c = c;
	}
	
	@Override
	public void run(){
		System.out.println();
		System.out.println("Thread sendo executada: " + Thread.currentThread().getName());
		for (int i = 0; i < 1000; i++) {
			System.out.print(c);
			if( i % 100 == 0)  {
				System.out.println();
			}
			
		}
	}
	
}

class ThreadRunnable implements Runnable{
	private char c;

	public ThreadRunnable(char c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		System.out.println();
		System.out.println("Thread sendo executada: " + Thread.currentThread().getName());
		for (int i = 0; i < 100; i++) {
			System.out.print(" " + Thread.currentThread().getName() + " -");
			if( i % 10 == 0)  {
				System.out.println();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
		
}

public class TestThreads {

	public static void main(String[] args) {
		System.out.println();
		System.out.println(Thread.currentThread().getName());
//		ThreadExemplo t1 = new ThreadExemplo('A');
//		ThreadExemplo t2 = new ThreadExemplo('B');
//		ThreadExemplo t3 = new ThreadExemplo('c');
//		ThreadExemplo t4 = new ThreadExemplo('D');
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
		
		Thread tr1 = new Thread( new ThreadRunnable('A'),"TR1");
		Thread tr2 = new Thread( new ThreadRunnable('B'),"TR2");
		Thread tr3 = new Thread( new ThreadRunnable('C'),"TR3");
		Thread tr4 = new Thread( new ThreadRunnable('D'),"TR4");
		
		tr1.start();;
		tr2.start();
		tr3.start();
		tr4.start();		
		
		// chamar a mesma thread
		// mesmo que esteja finalizada
		// dara erro java.lang.IllegalThreadStateException
		
		/*boolean espera = true;
		while (espera) {
			if (!tr1.isAlive()) {
				System.out.printf("\n============================("+Thread.currentThread().getName()+")\n");
				System.out.printf("\nTentando reiniciar thread: " + tr1.getName() + " " + tr1.isAlive() + "\n");
				System.out.println("============================");
				espera =false;
				tr1.start();
			}
		}*/

	}

}
