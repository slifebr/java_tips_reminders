package core.threads.classes;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ContadorComLock {

	private int count;
	private AtomicInteger atomicInteger = new AtomicInteger();
	private Lock lock = new ReentrantLock();

	public void increment() {
		lock.lock();
		try {
			count++;
			atomicInteger.getAndIncrement();
		} finally {
			lock.unlock();
		}
	}

	public int getCount() {
		return count;
	}

	public int getAtomicInteger() {
		return atomicInteger.get();
	}

}
