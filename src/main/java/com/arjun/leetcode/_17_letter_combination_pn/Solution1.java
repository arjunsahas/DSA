package com.arjun.leetcode._17_letter_combination_pn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution1 {

    private static final Map<String, String> keyboard = Map.of("2", "abc",
            "3", "def",
            "4", "ghi",
            "5", "jkl",
            "6", "mno",
            "7", "pqrs",
            "8", "tuv",
            "9", "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> buttonKeysCombinations = new ArrayList<>();

        if (digits.length() == 1) {
            String e = keyboard.get(digits.charAt(0) + "");
            for (char c : e.toCharArray()) {
                buttonKeysCombinations.add(c + "");
            }
        }

        int lenOfDigits = digits.length();
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < lenOfDigits; i++) {
            char c = digits.charAt(i);
            String buttonKeys = keyboard.get(c + "");
            inputs.add(buttonKeys);
        }

        int[] pointers = new int[inputs.size()];
        findCombinations(buttonKeysCombinations, inputs, pointers);

        return buttonKeysCombinations;
    }

    private void findCombinations(List<String> combinations, List<String> buttonKeys, int[] pointers) {

        while (pointers[0] != pointers.length - 1) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < buttonKeys.size(); i++) {
                str.append(buttonKeys.get(i).charAt(pointers[i]));
            }
            combinations.add(str.toString());

            for (int i = pointers.length - 1; i > 0; i--) {
//                if (pointers[i] == pointers.length - 1 && i == 0) {
//                    break;
//                } else
                if (i == pointers.length - 1 && pointers[pointers.length - 1] < pointers.length - 1) {
                    pointers[pointers.length - 1]++;
                    break;
                } else if (pointers[i] == pointers.length - 1 && i > 0) {
                    pointers[i] = 0;
                    if (pointers[i - 1] < pointers.length - 1) pointers[i - 1]++;
                    else pointers[i - 1] = 0;
                }
            }

        }

//        if (pointers[0] != pointers.length - 1) {
//            StringBuilder str = new StringBuilder();
//            for (int i = 0; i < buttonKeys.size(); i++) {
//                str.append(buttonKeys.get(i).charAt(pointers[i]));
//            }
//            combinations.add(str.toString());
//            pointers[pointers.length - 1]++;
//            findCombinations(combinations, buttonKeys, pointers);
//        }

    }

    public static void main(String[] args) {
        List<String> strings = new Solution1().letterCombinations("234");
        System.out.println(strings);
    }
}
