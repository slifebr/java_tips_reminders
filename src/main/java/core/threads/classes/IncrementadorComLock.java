package core.threads.classes;

public class IncrementadorComLock extends Thread {
	private ContadorComLock contador;
    private int num = 100;
    private String thread;
    
	public IncrementadorComLock(ContadorComLock contador,String thread) {
		this.contador = contador;
		this.thread = thread;
	}

	public void run() {
		
		for (int i = 0; i < num; i++) {
			contador.increment();
			System.out.println(i + " - " + thread);
		}
	}

}
