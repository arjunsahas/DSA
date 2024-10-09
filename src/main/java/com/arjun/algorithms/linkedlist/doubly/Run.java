package com.arjun.algorithms.linkedlist.doubly;

import java.util.Iterator;

/** Created by arjuns on 29/4/17. */
public class Run {

  public static void main(String[] args) {
    DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();

    linkedList.insert(3);
    linkedList.insert(4);
    linkedList.insert(5);
    linkedList.insert(7);

    linkedList.insertAtBeginning(1);
    linkedList.insertAt(2, 2);

    Iterator<Integer> iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      Integer next = iterator.next();
      System.out.println(next);
    }
  }
}
