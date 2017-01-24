package com.arjun.threads.lock.print;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    PrintQueue printQueue = new PrintQueue();
    Thread thread[] = new Thread[10];
    for(int i = 0; i < 10; i++) {
      thread[i] = new Thread(new Job(printQueue), "Thread " + i);
    }
    for(int i = 0; i < 10; i++) {
      thread[i].start();
    }
    for(int i = 0; i < 10; i++) {
      try {
        thread[i].join();
      }
      catch(InterruptedException e) {
        e.printStackTrace();
      }      
    }
  }

}
