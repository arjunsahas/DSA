package com.arjun.leetcode._21_merge_sorted_lists;

import com.arjun.leetcode.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 */
class Solution {
    // the intuition is to iterate through the list1 till a condition and then break and then repeat in the list2.
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode mergeHead = new ListNode();
        ListNode curr = mergeHead;
        while (true) {
            if (list1 != null && list2 != null) {
                while (list2 != null && list1 != null) {
                    if (list1.val <= list2.val) {
                        curr.next = new ListNode(list1.val);
                        list1 = list1.next;
                        curr = curr.next;
                    } else {
                        curr.next = new ListNode(list2.val);
                        curr = curr.next;
                        list2 = list2.next;
                        break;
                    }
                }
                while (list1 != null && list2 != null) {
                    if (list2.val <= list1.val) {
                        curr.next = new ListNode(list2.val);
                        list2 = list2.next;
                        curr = curr.next;
                    } else {
                        curr.next = new ListNode(list1.val);
                        curr = curr.next;
                        list1 = list1.next;
                        break;
                    }
                }
            } else if (list1 == null && list2 != null) {
                while (list2 != null) {
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                    list2 = list2.next;
                }
            } else if (list1 != null && list2 == null) {
                while (list1 != null) {
                    curr.next = new ListNode(list1.val);
                    curr = curr.next;
                    list1 = list1.next;
                }
            } else break;
        }
        return mergeHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(10, new ListNode(11)));

        ListNode head2 = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(12))))));

        ListNode listNode = new Solution().mergeTwoLists1(head1, head2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    // 1 10 11

    // 2 3 4 5 6 12
}