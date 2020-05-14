package com.arjun.algorithms.tree.binarysearch;

public class BinarySearchTree {

    public static class Node {
        private Node left;
        private Node right;
        private Integer key;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return Integer.toString(getKey());
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + key;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            if (key != other.key)
                return false;
            return true;
        }

    }

}
