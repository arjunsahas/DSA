package com.arjun.algorithms.linkedlist.problems;

class ReverseLinkedList {
    Node reverse(Node head) {
        LinkedList list = new LinkedList();
        while (head != null) {
            list.insert(0, head.data);
            head = head.next;
        }
        return list.getFirst();
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.data = 1;
        node.next = null;

        Node node2 = new Node();
        node2.data = 1;
        node2.next = null;

        node.next = node2;


        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node reverse = reverseLinkedList.reverse(node);
        System.out.println(reverse.data);

        LinkedList linkedList = new LinkedList();
        Node node1 = linkedList.InsertNth(null, 3, 0);
        node1 = linkedList.InsertNth(node1, 5, 1);
        node1 = linkedList.InsertNth(node1, 4, 2);
        node1 = linkedList.InsertNth(node1, 2, 3);
        node1 = linkedList.InsertNth(node1, 10, 1);
        while (node1 != null) {
            System.out.print(node1.data);
            node1 = node1.next;
        }
    }
}


class Node {
    int data;
    Node next;
}

class LinkedList {

    Node head = null;

    public void insert(int index, int n) {
        if (head == null) {
            head = new Node();
            head.data = n;
        } else {
            if (index == 0) {
                Node node = new Node();
                node.data = n;
                node.next = head;
                head = node;
            }
        }
    }

    Node InsertNth(Node head, int data, int position) {
        if (head == null) {
            head = new Node();
            head.data = data;
        } else if (position == 0 && head != null) {
            Node node = new Node();
            node.data = data;
            node.next = head;
            head = node;
        } else {
            int count = 0;
            System.out.println(head.data);
            Node left = head;
            while (left != null) {
                if (count == position - 1) {
                    Node inbetween = new Node();
                    inbetween.data = data;
                    Node right = left.next;
                    inbetween.next = right;
                    left.next = inbetween;
                    break;
                } else {
                    count++;
                    left = left.next;
                }
            }
        }
        return head;
    }

    public Node getFirst() {
        return head;
    }
}
