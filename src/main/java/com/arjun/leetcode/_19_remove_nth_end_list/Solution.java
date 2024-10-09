package com.arjun.leetcode._19_remove_nth_end_list;

import com.arjun.leetcode.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list
 *
 * <p>Intuition is to have two pointer and iterate the fast pointer first to a certain position and
 * then iterate the slow ppinter till the end of the fast pointer.
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode fast = head, slow = head, prev = dummy;
    int count = n;
    while (count > 0) {
      fast = fast.next;
      count--;
    }
    while (fast != null) {
      prev = slow;
      fast = fast.next;
      slow = slow.next;
    }
    prev.next = slow.next;
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head2 =
        new ListNode(
            2,
            new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(12))))));
    ListNode listNode = new Solution().removeNthFromEnd(head2, 1);
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }
}
