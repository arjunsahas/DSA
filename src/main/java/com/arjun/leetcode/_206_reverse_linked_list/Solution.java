package com.arjun.leetcode._206_reverse_linked_list;


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode l2End = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode l2i = new ListNode(head.val);
            l2i.next = l2End;
            l2End = l2i;
            head = head.next;
        }
        return l2End;
    }

    public class ListNode {
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
}