package core.threads.classes.concorrencia;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListaMembros {
	private final Queue<String> emails = new LinkedList<>();
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();
	
	private boolean aberta = true;
	
	public int getEmailsPendentes() {
		/* trocado pelo lock
		synchronized (emails ) {
			return this.emails.size();
		*/
		lock.lock();
		try {
			return this.emails.size();
		} finally {
			lock.unlock();
		}
		
	}
	
	public boolean isAberta() {
		return aberta;
	}
	
	public String obterEmailMembro() {
		String email = null;
		try {
			lock.lock();
			//synchronized(this.emails) {
				while (this.emails.size() == 0) {
					if (!aberta) return null;
					System.out.println("Lista vazia, colocando a thread: " + Thread.currentThread().getName() + " em modo " + Thread.currentThread().getState());
					//this.emails.wait();	// libera lock do objeto (com synchronized)
					condition.await(); // libera o lock do objeto(com ReentrantLock)
				}
				email = this.emails.poll(); // recupera o primeiro item da fila
			//}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("desbloqueando lock");
			lock.unlock();
		}
		return email;
	}
	
	public void adicionarEmailMembro(String email) {
		
		//synchronized(this.emails) {
		lock.lock();
		try {
			this.emails.add(email);
			System.out.println("Email adicionado na lista");
			System.out.println("Notificando as Threads que estão em espera " + Thread.currentThread().getName());
			//this.emails.notifyAll(); // com synchronized
			condition.signalAll(); // com ReentrantLock
		} finally {
			lock.unlock();
		}
		//}
	}
	
	public void fecharLista() {
		System.out.println("Notificando todas as Threads o fechamento da lista");
		aberta = false;
		/*
		synchronized (this.emails) {
			this.emails.notifyAll();
		}
		*/
		lock.lock();
		try {
			//this.emails.notifyAll();
			//condition.signalAll();
		} finally {
			lock.unlock();
		}
		
	}

}
