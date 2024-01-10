package com.arjun.leetcode._82_removeduplicates;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode curr = head, prev = dummy, prevprev = dummy;
        while (curr != null) {
            if (prev.val == curr.val) {
                curr = countDuplicates(prev, curr);
                prevprev.next = curr;
                prev = prevprev;
            } else {
                prevprev = prev;
                prev = curr;
                curr = curr.next;
            }
            System.out.println("Prevprev: " + prevprev.val);
            System.out.println("Prev: " + prev.val);
            if (curr != null)
                System.out.println("Curr: " + curr.val);
        }
        return dummy.next;
    }

    private ListNode countDuplicates(ListNode prev, ListNode curr) {
        while (curr != null) {
            if (prev.val == curr.val) {
                curr = curr.next;
            } else return curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] array = {1,1, 2, 3, 3, 4, 4, 5};
        ListNode head = new ListNode(array[0]);
        ListNode curr = head;
        for (int i = 1; i < array.length; i++) {
            ListNode n = new ListNode(array[i]);
            curr.next = n;
            curr = n;
        }
        ListNode listNode = new Solution().deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}