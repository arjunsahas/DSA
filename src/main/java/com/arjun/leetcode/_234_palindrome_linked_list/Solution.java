package com.arjun.leetcode._234_palindrome_linked_list;

import com.arjun.leetcode.ListNode;

class Solution {
    public boolean isPalindrome(ListNode head) {
        String pal = "";
        while (head != null) {
            pal += head.val;
            head = head.next;
        }
        return checkPalindrome(pal);
    }

    private boolean checkPalindrome(String str) {
        int i = 0;
        int e = str.length() - 1;
        while (i < Math.floor(str.length() / 2)) {
            if (str.charAt(i) != str.charAt(e)) return false;
            i++;
            e--;
        }
        return true;
    }
}