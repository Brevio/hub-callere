package br.com.bradesco.services;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Pool {

	private ScheduledThreadPoolExecutor pool;
	private int capacity;

	public Pool(int capacity) {
		this.capacity = capacity;
		pool = new ScheduledThreadPoolExecutor(capacity);
	}

	public void execute(Runnable task) {
		pool.execute(task);
	}

	public void release(Runnable task) {
		pool.remove(task);
	}

	public int getCapacity() {
		return capacity;
	}

	public int getRunningCount() {
		return pool.getActiveCount();
	}

	public void forceDone() {
		pool.shutdown();
	}

	public boolean isDone() {
		return pool.isShutdown();
	}
}
