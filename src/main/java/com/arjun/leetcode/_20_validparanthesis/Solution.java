package com.arjun.leetcode._20_validparanthesis;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() <= 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if ((peek == '(' && c == ')') || (peek == '{' && c == '}') || (peek == '[' && c == ']')) {
                        stack.pop();
                    }
                    else stack.push(c);
                }  else stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}
