package com.arjun.algorithms.stack.problem;

import java.util.Scanner;
import java.util.Stack;

/** https://www.hackerrank.com/challenges/ctci-balanced-brackets */
public class BalancedBrackets {

  public static boolean isBalanced(String expression) {
    int length = expression.length();
    if (length % 2 != 0) {
      return false;
    }
    char[] charArray = expression.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < length; i++) {
      if (charArray[i] == '{' || charArray[i] == '[' || charArray[i] == '(')
        stack.push(charArray[i]);
      else {
        if (stack.empty()) {
          return false;
        }
        char c = (char) stack.peek();
        if ((c == '{' && charArray[i] == '}')
            || (c == '[' && charArray[i] == ']')
            || (c == '(' && charArray[i] == ')')) {
          stack.pop();
        }
      }
    }
    if (stack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean isBalanced1(String expression) {
    // Must be even
    if ((expression.length() & 1) == 1) return false;
    else {
      char[] brackets = expression.toCharArray();
      Stack<Character> s = new Stack<>();
      for (char bracket : brackets)
        switch (bracket) {
          case '{':
            s.push('}');
            break;
          case '(':
            s.push(')');
            break;
          case '[':
            s.push(']');
            break;
          default:
            if (s.empty() || bracket != s.peek()) return false;
            s.pop();
        }
      return s.empty();
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      String expression = in.next();
      System.out.println((isBalanced(expression)) ? "YES" : "NO");
    }
  }
}
