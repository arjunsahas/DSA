package com.arjun.algorithms.linkedlist.singly;

/** Created by arjuns on 27/4/17. */
import java.util.Iterator;

public class Run {
  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.insert(4);
    linkedList.insert(6);
    linkedList.insertAtBeginning(3);
    linkedList.insertAtBeginning(2);
    linkedList.insertAtBeginning(1);
    linkedList.insertAt(4, 5);

    Iterator<Integer> iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    linkedList.delete();

    iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
