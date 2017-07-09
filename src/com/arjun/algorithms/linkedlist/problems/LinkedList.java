package com.arjun.algorithms.linkedlist.problems;/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as  
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 
Node Reverse(Node head) {
    LinkedList list = new LinkedList();
    if(head != null){
        list.insert(0,head.data);
        head = head.next;
    }
    return list.getFirst();
}

  

class LinkedList{
      
    Node head = null;
    
    public void insert(int index, int n){
        if(head == null){
            head = new Node();
            head.data = n;
        }else{
            if(index == 0){
                Node node = new Node();
                node.data = n;
                node.next = head;
                head = node;
            }
        }
    }
    
    public Node getFirst(){
        return head;
    }
}
