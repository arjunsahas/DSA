package com.arjun.threads.lock.print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintQueue {
  Lock queueLock = new ReentrantLock();

  public void printJob(Object document) {
    // queueLock.lock();
    boolean lock = queueLock.tryLock();
    System.out.println(Thread.currentThread().getName() + " has access " + lock);
    try {
      Long duration = (long) (Math.random() * 10000);
      System.out.println(
          Thread.currentThread().getName()
              + ":PrintQueue: Printing a Job during "
              + (duration / 1000)
              + " seconds");
      Thread.sleep(duration);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (lock) queueLock.unlock();
    }
  }
}

class Job implements Runnable {
  private PrintQueue queue;

  public Job(PrintQueue queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
    queue.printJob(new Object());
    System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
  }
}
