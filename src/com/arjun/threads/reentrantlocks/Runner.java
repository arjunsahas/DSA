package com.arjun.threads.reentrantlocks;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private LinkedList<Integer> list = new LinkedList<>();
	private static final int LIMIT = 10;
	private Random random;

	public Runner() {
		random = new Random();
	}

	public void produce() throws InterruptedException {
		int i = random.nextInt(10);
		lock.lock();
		if (list.size() == LIMIT) {
			condition.await();
		}
		list.add(i);
		System.out.println("Added " + i + " size : " + list.size());
		condition.signal();
		lock.unlock();
	}

	public void consume() throws InterruptedException {
		lock.lock();
		if(list.isEmpty()){
			condition.await();
		}
		int firstEl = list.removeFirst();
		System.out.println("Removed " + firstEl + " size : " + list.size());
		Thread.sleep(3000);
		condition.signal();
		lock.unlock();
	}
}
