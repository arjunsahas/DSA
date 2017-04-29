package com.arjun.algorithms.linkedlist.doubly;


import java.util.Iterator;

public class DoublyLinkedList<T> {

    public static class LLNode<T> {
        private T data;
        private LLNode previous;
        private LLNode next;

        public T getData() {
            return data;
        }

        public void setData(final T data) {
            this.data = data;
        }

        public LLNode getPrevious() {
            return previous;
        }

        public void setPrevious(final LLNode previous) {
            this.previous = previous;
        }

        public LLNode getNext() {
            return next;
        }

        public void setNext(final LLNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private LLNode<T> first;
    private LLNode<T> curr;

    public boolean insertAtBeginning(T data) {
        checkDataNull(data);
        if (first == null) {
            LLNode<T> node = createNode(data);
            first = node;
            curr = node;
        } else {
            LLNode<T> node = createNode(data);
            LLNode<T> temp = first;
            node.setNext(temp);
            first = node;
        }
        return true;
    }

    public boolean insert(T data) {
        checkDataNull(data);
        if (first == null) {
            LLNode<T> node = createNode(data);
            first = node;
            curr = node;
        } else {
            LLNode<T> previous = curr;
            LLNode<T> node = createNode(data);
            node.setPrevious(previous);
            previous.setNext(node);
            curr = node;
        }
        return true;
    }

    public boolean insertAt(int index, T data) {
        checkDataNull(data);
        if (first == null || index > size()) {
            throw new RuntimeException("index not found");
        }
        int count = 0;
        LLNode<T> curr = first;
        while (curr != null) {
            count++;
            if (index == count) {
                LLNode<T> node = createNode(data);
                LLNode next = curr.getNext();

                node.setPrevious(curr);
                node.setNext(next);

                curr.setNext(node);
            }
            curr = curr.getNext();
        }
        return true;
    }

    public int size() {
        int count = 0;
        if (first == null) {
            return count;
        } else {
            LLNode<T> curr = first;
            while (curr != null) {
                curr = curr.getNext();
                count++;
            }
        }
        return count;
    }

    public Iterator<T> iterator() {
        return new DLLIterator<T>(first);
    }


    private LLNode<T> createNode(final T data) {
        LLNode<T> node = new LLNode<>();
        node.setData(data);
        return node;
    }

    private void checkDataNull(final T data) {
        if (data == null) {
            throw new RuntimeException("data cannot be null");
        }
    }


    private class DLLIterator<T> implements Iterator<T> {

        LLNode<T> curr;

        public DLLIterator(final LLNode<T> first) {
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

        }
    }
}
