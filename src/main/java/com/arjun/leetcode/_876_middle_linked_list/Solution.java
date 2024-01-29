package com.arjun.leetcode._876_middle_linked_list;

import com.arjun.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode middleNode(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int length = nodes.size();
        int lenDivide = length / 2;
        return nodes.get(lenDivide);
    }


}