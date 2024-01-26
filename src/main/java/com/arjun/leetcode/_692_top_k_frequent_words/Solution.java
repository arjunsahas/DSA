package com.arjun.leetcode._692_top_k_frequent_words;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class Solution {

    static class HeapNode {
        private String value;
        private int occurrence;

        HeapNode(String value, int occurrence) {
            this.occurrence = occurrence;
            this.value = value;
        }

        @Override
        public String toString() {
            return "value " + value + " occurance " + occurrence;
        }

        public String getValue() {
            return value;
        }

        public int getOccurrence() {
            return occurrence;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<HeapNode> maxHeap = new ArrayList<>();
        for (String word : words) {
            buildHeap(maxHeap, word);
        }

        heapify(maxHeap);
        heapSort(maxHeap);
        maxHeap.sort((o1, o2) -> {
            if (o1.occurrence == o2.occurrence)
                return o1.value.compareTo(o2.value) > 0 ? -1 : 1;
            else return o1.occurrence - o2.occurrence > 0 ? 1 : -1;
        });
        List<String> strings = new ArrayList<>();
        for (int i = maxHeap.size() - 1; i >= 0; i--)
            strings.add(maxHeap.get(i).value);
        return strings.subList(0, k);
    }

    private void buildHeap(List<HeapNode> maxHeap, String word) {
        HeapNode heapNode = find(maxHeap, word);
        if (heapNode == null) {
            maxHeap.add(new HeapNode(word, 1));
        } else {
            heapNode.occurrence = heapNode.occurrence + 1;
        }
    }

    private void heapify(List<HeapNode> maxHeap) {
        int size = maxHeap.size();
        for (int i = size - 1; i >= 0; i--) {
            HeapNode parentNode = maxHeap.get(i);

            int leftChildPos = (i * 2) + 1;
            int rightChildPos = (i * 2) + 2;

            HeapNode leftChild = null;
            HeapNode rightChild = null;
            if (leftChildPos < size) {
                leftChild = maxHeap.get(leftChildPos);
            }
            if (rightChildPos < size) {
                rightChild = maxHeap.get(rightChildPos);
            }

            int swapPos = 0;

            HeapNode biggerSibling = null;
            if (leftChild != null && rightChild != null) {
                if (leftChild.occurrence > rightChild.occurrence) {
                    biggerSibling = leftChild;
                    swapPos = leftChildPos;
                } else {
                    biggerSibling = rightChild;
                    swapPos = rightChildPos;
                }
            } else if (leftChild == null && rightChild != null) {
                biggerSibling = rightChild;
                swapPos = rightChildPos;
            } else if (leftChild != null) {
                biggerSibling = leftChild;
                swapPos = leftChildPos;
            } // do nothing parentNode has no child

            if (biggerSibling != null) {
                if (biggerSibling.occurrence > parentNode.occurrence) { // swap
                    swap(maxHeap, i, parentNode, swapPos, biggerSibling);
                }

            }
        }
    }

    private void swap(List<HeapNode> maxHeap, int i, HeapNode parentNode, int swapPos, HeapNode biggerSibling) {
        HeapNode temp = parentNode;
        maxHeap.set(i, biggerSibling);
        maxHeap.set(swapPos, temp);
    }

    private HeapNode find(List<HeapNode> maxHeap, String word) {
        int size = maxHeap.size();
        for (int i = 0; i < size / 2; i++) {
            HeapNode heapNode = maxHeap.get(i);
            if (heapNode.value.equals(word)) return heapNode;

            int leftChildPos = (i * 2) + 1;
            int rightChildPos = (i * 2) + 2;

            HeapNode leftChild;
            HeapNode rightChild;
            if (leftChildPos < size) {
                leftChild = maxHeap.get(leftChildPos);
                if (leftChild.value.equals(word)) return leftChild;
            }
            if (rightChildPos < size) {
                rightChild = maxHeap.get(rightChildPos);
                if (rightChild.value.equals(word)) return rightChild;
            }

        }
        return null;
    }

    private void heapSort(List<HeapNode> maxHeap) {
        int end = maxHeap.size();
        for (int i = end - 1; i >= 0; i--) {
            HeapNode lastNode = maxHeap.get(i);
            swap(maxHeap, i, lastNode, 0, maxHeap.get(0));
            heapify(maxHeap.subList(0, i));
        }
    }

    public static void main(String[] args) {

        List<String> strings = new Solution().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3);
        System.out.println(strings);

        strings = new Solution().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        System.out.println(strings);

        strings = new Solution().topKFrequent(new String[]{"up", "upstox", "broking", "finance", "stocks", "up", "upstox", "up"}, 4);
        System.out.println(strings);
    }
}
