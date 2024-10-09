package com.arjun.algorithms.queue.problem;

import java.util.Scanner;
import java.util.Stack;

public class TwoStacks {
  public static class MyQueue<T> {
    Stack<T> stackNewestOnTop = new Stack<>();
    Stack<T> stackOldestOnTop = new Stack<>();

    // Too Slow.
    public void enqueue(T value) { // Push onto newest stack
      while (!stackOldestOnTop.isEmpty()) {
        stackNewestOnTop.push(stackOldestOnTop.pop());
      }
      stackNewestOnTop.push(value);
      while (!stackNewestOnTop.empty()) {
        stackOldestOnTop.push(stackNewestOnTop.pop());
      }
    }

    // Optimal
    private void populateOld() {
      if (stackOldestOnTop.isEmpty()) {
        while (!stackNewestOnTop.empty()) {
          stackOldestOnTop.push(stackNewestOnTop.pop());
        }
      }
    }

    public void enqueue1(T value) { // Push onto newest stack
      stackNewestOnTop.push(value);
    }

    public T peek() {
      populateOld();
      T peek = stackOldestOnTop.peek();
      return peek;
    }

    public T dequeue() {
      populateOld();
      T pop = stackOldestOnTop.pop();
      stackNewestOnTop.remove(pop);
      return pop;
    }
  }

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) { // enqueue
        queue.enqueue1(scan.nextInt());
      } else if (operation == 2) { // dequeue
        queue.dequeue();
      } else if (operation == 3) { // print/peek
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }
}
