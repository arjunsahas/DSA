package com.arjun.algorithms.stack.fixed;

/** Created by arjuns on 30/4/17. */
public class Stack<T> {

  private T[] array = null;
  private int top = 0;
  private int curr = 0;

  public Stack(int size) {
    array = (T[]) new Object[size];
  }

  public void push(T data) {
    checkDataNull(data);
    if (isFull()) {
      throw new RuntimeException(data + " cannot be inserted. stack is full");
    }
    array[top] = data;
    top++;
  }

  public T pop() {
    if (isEmpty()) {
      throw new RuntimeException("data cannot be popped. stack is empty");
    }
    T data = array[--top];
    array[top] = null;
    return data;
  }

  public T top() {
    return array[top];
  }

  public int size() {
    int count = 0;
    for (T t : array) {
      if (t != null) {
        count++;
      } else break;
    }
    return count;
  }

  public boolean isEmpty() {
    return top == 0;
  }

  public boolean isFull() {
    return top == array.length;
  }

  private void checkDataNull(final T data) {
    if (data == null) {
      throw new RuntimeException(data + " is null");
    }
  }
}
