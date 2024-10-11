package com.arjun.threads.countdownlatch;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class App {
  public static void main(String[] args) {
    App app = new App();
    app.run();
  }

  int sum = 0;
  int product = 0;

  private void run() {
    final CountDownLatch countDownLatch = new CountDownLatch(2);
    Thread t1 =
        new Thread(
            new Runnable() {

              @Override
              public void run() {
                System.out.println("Enter to Add");
                Scanner scanner = new Scanner(System.in);
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                sum = add(a, b);
                countDownLatch.countDown();
              }
            });

    Thread t2 =
        new Thread(
            () -> {
              System.out.println("Enter to Multiply");
              Scanner scanner = new Scanner(System.in);
              int a = scanner.nextInt();
              int b = scanner.nextInt();
              product = product(a, b);
              countDownLatch.countDown();
            });

    t1.start();
    t2.start();
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Answer is " + (sum + product));
  }

  private int add(int a, int b) {
    return a + b;
  }

  private int product(int a, int b) {
    return a * b;
  }
}
