package core.threads.test;

import core.threads.classes.ContadorComLock;
import core.threads.classes.IncrementadorComLock;

public class TesteAtomicComLock  {

	public static void main(String[] args) throws InterruptedException {
		ContadorComLock c = new ContadorComLock();

		IncrementadorComLock it1 = new IncrementadorComLock(c,"T1");
		IncrementadorComLock it2 = new IncrementadorComLock(c,"T2");


		it1.start();
		it2.start();

		it1.join();
		it2.join();		
	

		System.out.println("Thread normal com synchronized: " + c.getCount());
		System.out.println("Variavel atomica sem ExecutorService: " + c.getAtomicInteger());

	}

}
