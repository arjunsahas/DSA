package com.arjun.leetcode._17_letter_combination_pn;

import java.util.*;

/** https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */
class Solution {

  private static final Map<String, String> keyboard =
      Map.of(
          "2", "abc", "3", "def", "4", "ghi", "5", "jkl", "6", "mno", "7", "pqrs", "8", "tuv", "9",
          "wxyz");

  public List<String> letterCombinations(String digits) {
    List<String> buttonKeysCombinations = new ArrayList<>();

    if (digits.length() == 1) {
      String e = keyboard.get(digits.charAt(0) + "");
      for (char c : e.toCharArray()) {
        buttonKeysCombinations.add(c + "");
      }
    }

    int lenOfDigits = digits.length();
    Set<String> correctCombinationSet = new HashSet<>();

    for (int i = 0; i < lenOfDigits; i++) {
      char c = digits.charAt(i);
      String buttonKeys1 = keyboard.get(c + "");
      for (int j = 0; j < lenOfDigits; j++) {
        if (i == j) continue;
        char c1 = digits.charAt(j);
        String buttonKeys2 = keyboard.get(c1 + "");
        String combination = String.valueOf(c) + c1;
        String reverseCombination = String.valueOf(c1) + c;
        if (correctCombinationSet.isEmpty()) {
          findCombinations(buttonKeysCombinations, buttonKeys1, buttonKeys2);
          correctCombinationSet.add(combination);
        } else if (!correctCombinationSet.contains(combination)
            && !correctCombinationSet.contains(reverseCombination)) {
          findCombinations(buttonKeysCombinations, buttonKeys1, buttonKeys2);
          correctCombinationSet.add(combination);
        }
      }
    }
    return buttonKeysCombinations;
  }

  private void findCombinations(List<String> combinations, String buttonKeys1, String buttonKeys2) {
    for (int i = 0; i < buttonKeys1.length(); i++) {
      char c = buttonKeys1.charAt(i);
      for (int j = 0; j < buttonKeys2.length(); j++) {
        char c1 = buttonKeys2.charAt(j);
        String str = String.valueOf(c) + c1;
        combinations.add(str);
      }
    }
  }

  public static void main(String[] args) {
    List<String> strings = new Solution().letterCombinations("234");
    System.out.println(strings);
  }
}
