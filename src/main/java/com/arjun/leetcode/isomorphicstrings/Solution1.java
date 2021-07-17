package com.arjun.leetcode.isomorphicstrings;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>(); // map of original character to replace character.
        for (int i = 0; i < t.length(); i++) {
            char o = s.toCharArray()[i];
            char r = t.toCharArray()[i];
            if (map.get(o) == null) {
                if (map.values().contains(r)) {
                    return false;
                }
                map.put(o, r);
            } else if (map.get(o) != r)
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        new Solution1().isIsomorphic("badc", "baba");
    }
}
