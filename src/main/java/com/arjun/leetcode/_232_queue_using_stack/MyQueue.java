package com.arjun.leetcode._232_queue_using_stack;

import java.util.Stack;

class MyQueue {
  Stack<Integer> stack = new Stack<>();

  public MyQueue() {}

  public void push(int x) {
    stack.push(x);
  }

  public int pop() {
    Integer lastElement = -1;

    if (!stack.isEmpty()) {
      lastElement = stack.firstElement();
      stack.remove(lastElement);
    }
    return lastElement;
  }

  public int peek() {
    Integer lastElement = -1;

    if (!stack.isEmpty()) {
      lastElement = stack.firstElement();
    }
    return lastElement;
  }

  public boolean empty() {
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(3);

    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.peek());

    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());

    System.out.println(queue.empty());
  }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */
