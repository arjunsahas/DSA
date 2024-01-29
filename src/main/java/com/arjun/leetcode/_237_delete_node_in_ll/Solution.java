package com.arjun.leetcode._237_delete_node_in_ll;

import com.arjun.leetcode.ListNode;

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}