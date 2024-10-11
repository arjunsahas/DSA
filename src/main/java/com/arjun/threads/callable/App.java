package com.arjun.threads.callable;

import java.util.concurrent.*;

public class App {
  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(10);
    Future<Integer> future = service.submit(() -> 1);

    service.shutdown();
    try {
      System.out.println("Result : " + future.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
