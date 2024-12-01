package com.arjun.threads.blockedarrayqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();
  private BlockingQueue<Integer> list = new ArrayBlockingQueue<Integer>(10);
  private static final int LIMIT = 10;
  private Random random;

  public Runner() {
    random = new Random();
  }

  public void produce() throws InterruptedException {
    int i = random.nextInt(10);
    lock.lock();
    if (list.size() == LIMIT) {
      System.out.println("Reached Limit");
      condition.await();
    }
    list.put(i);
    System.out.println("Added " + i + ", size : " + list.size());
    condition.signal();
    lock.unlock();
  }

  public void consume() throws InterruptedException {
    lock.lock();
    if (list.isEmpty()) {
      System.out.println("List Empty");
      condition.await();
    }
    int firstEl = list.take();
    System.out.println("Removed " + firstEl + " size : " + list.size());
    Thread.sleep(3000);
    condition.signal();
    lock.unlock();
  }
}
