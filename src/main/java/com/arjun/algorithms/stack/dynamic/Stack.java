package com.arjun.algorithms.stack.dynamic;

/** Created by arjuns on 30/4/17. */
public class Stack<T> {

  private int n = 1;
  private T[] array = null;
  private int top = 0;
  private int curr = 0;

  public Stack() {
    array = (T[]) new Object[1];
  }

  public void push(T data) {
    checkDataNull(data);
    resize();
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
    resize();
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

  public void resize() {
    if (array.length == size()) {
      T[] objects = (T[]) new Object[array.length * 2];
      System.out.println("array doubled from " + array.length + " to " + objects.length);
      System.arraycopy(array, 0, objects, 0, array.length);
      array = objects;
    }
  }

  private void checkDataNull(final T data) {
    if (data == null) {
      throw new RuntimeException(data + " is null");
    }
  }
}
