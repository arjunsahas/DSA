package com.arjun.algorithms.linkedlist.singly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList<T> {

  public static class Node<T> {
    private T data;
    private Node<T> next;

    public T getData() {
      return data;
    }

    public void setData(final T data) {
      this.data = data;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(final Node<T> next) {
      this.next = next;
    }
  }

  private Node<T> first;
  private Node<T> curr;

  public boolean insertAtBeginning(T data) {
    checkDataNull(data);
    if (first == null) {
      createFirstNode(data);
    } else {
      Node<T> node = createNode(data);
      node.setNext(first);
      first = node;
    }
    return true;
  }

  private void createFirstNode(final T data) {
    Node<T> node = createNode(data);
    first = node;
    curr = node;
  }

  public boolean insert(T data) {
    checkDataNull(data);
    if (first == null) {
      createFirstNode(data);
    } else {
      Node<T> node = createNode(data);
      node.setNext(null);
      curr.setNext(node);
      curr = node;
    }
    return true;
  }

  public boolean insertAt(int index, T data) {
    checkDataNull(data);
    if (first == null || index > size()) {
      throw new RuntimeException("index not found");
    }
    Node<T> curr = first;
    int count = 0;
    Node<T> previous = null;
    while (curr != null) {
      if (count == index) {
        Node<T> node = createNode(data);
        previous.setNext(node);
        node.setNext(curr);
        break;
      }
      previous = curr;
      curr = curr.getNext();
      count++;
    }
    return true;
  }

  public boolean delete() {
    Node<T> node = first;
    Node<T> lastButOne = null;
    // checking if next node is not null and then assigning the previous one as lastButOne.
    while (node.getNext() != null) {
      lastButOne = node;
      node = node.getNext();
    }
    curr = lastButOne;
    curr.setNext(null);
    return true;
  }

  public int size() {
    int count = 0;
    if (first == null) {
      return count;
    } else {
      Node curr = first;
      while (curr != null) {
        curr = curr.getNext();
        count++;
      }
    }
    return count;
  }

  private Node<T> createNode(final T data) {
    Node<T> node = new Node<>();
    node.setData(data);
    return node;
  }

  private boolean insert(int index, T data) {
    // TODO
    return true;
  }

  private void checkDataNull(final T data) {
    if (data == null) {
      throw new RuntimeException("data cannot be null");
    }
  }

  boolean hasCycle(Node head) {
    if (head == null) {
      return false;
    }

    List<Node> list = new ArrayList<>();

    Node n = head;
    list.add(n);
    while (n != null) {
      n = n.next;
      if (list.contains(n)) {
        return true;
      }
      list.add(n);
    }
    return true;
  }

  public Iterator iterator() {
    return new LinkedListIterator(first);
  }

  private class LinkedListIterator implements Iterator<T> {
    Node<T> curr;

    public LinkedListIterator(final Node<T> first) {
      curr = first;
    }

    @Override
    public boolean hasNext() {
      return curr != null;
    }

    @Override
    public T next() {
      T data = curr.getData();
      curr = curr.getNext();
      return data;
    }

    @Override
    public void remove() {
      // TODO
    }
  }
}
