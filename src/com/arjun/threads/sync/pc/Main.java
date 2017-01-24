package com.arjun.threads.sync.pc;

public class Main {
  public static void main(String[] args) {
    EventStorage eventStorage = new EventStorage();

    Producer producer = new Producer(eventStorage);
    Consumer consumer = new Consumer(eventStorage);

    Thread thread1 = new Thread(producer);
    Thread thread2 = new Thread(consumer);

    thread1.start();
    thread2.start();

  }
}