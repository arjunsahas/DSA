package com.arjun.threads.executors;

public class Runner implements Runnable {
  private int id;

  public Runner(int id) {
    this.id = id;
  }

  @Override
  public void run() {
    System.out.println("Starting " + id);

    try {
      Thread.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Completed " + id);
  }
}
