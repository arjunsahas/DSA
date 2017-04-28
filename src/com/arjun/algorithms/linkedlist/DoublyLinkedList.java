package com.arjun.algorithms.linkedlist;

public class DoublyLinkedList {
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



}
