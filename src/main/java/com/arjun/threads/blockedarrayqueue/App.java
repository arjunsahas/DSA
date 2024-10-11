package com.arjun.threads.blockedarrayqueue;

public class App {
  public static void main(String[] args) {
    final Runner runner = new Runner();
    Thread t1 =
        new Thread(
            () -> {
              try {
                while (true) {
                  runner.produce();
                }
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });

    Thread t2 =
        new Thread(
            () -> {
              try {
                while (true) {
                  runner.consume();
                }
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
