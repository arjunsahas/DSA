package com.arjun.leetcode.middleoflinkedlist;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode middleNode(ListNode head) {
        List<ListNode> nodes =  new ArrayList<>();
        while(head != null) {
            nodes.add(head);
            head = head.next;
        }
        int length = nodes.size();
        int lenDivide = length / 2;
        return nodes.get(lenDivide);
    }

    
    public static class ListNode {
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