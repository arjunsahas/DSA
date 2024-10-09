package com.arjun.leetcode.mergelinkedlists;

class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) return null;
    if (list1 == null) return list2;
    if (list2 == null) return list1;

    ListNode newHead = createNode(0);
    ListNode curr = newHead;
    while (true) {
      if (list1 != null && list2 != null) {
        if (list1.val >= list2.val) {
          ListNode v1 = createNode(list1.val);
          ListNode v2 = createNode(list2.val);
          curr.next = v2;
          v2.next = v1;
          curr = v1;
        } else if (list1.val <= list2.val) {
          ListNode v1 = createNode(list1.val);
          ListNode v2 = createNode(list2.val);
          curr.next = v1;
          v1.next = v2;
          curr = v2;
        }
      } else {
        if (list1 == null) {
          while (list2 != null) {
            ListNode n = createNode(list2.val);
            curr.next = n;
            curr = n;
            list2 = list2.next;
          }
          break;
        } else {
          appendList(curr, list1);
          break;
        }
      }
      list1 = list1.next;
      list2 = list2.next;
    }
    return newHead.next;
  }

  private ListNode createNode(int val) {
    return new ListNode(val);
  }

  private void appendList(ListNode curr, ListNode list) {
    while (list != null) {
      ListNode n = createNode(list.val);
      curr.next = n;
      curr = n;
      list = list.next;
    }
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(4);
    n1.next = n2;
    n2.next = n3;

    ListNode n4 = new ListNode(1);
    ListNode n5 = new ListNode(3);
    ListNode n6 = new ListNode(5);
    n4.next = n5;
    n5.next = n6;

    ListNode n = new Solution().mergeTwoLists(n1, n4);
    while (n != null) {
      System.out.println(n.val);
      n = n.next;
    }
  }
}
