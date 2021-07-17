package com.arjun.leetcode.isomorphicstrings;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    private static boolean isomorphic;

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Boolean> boolMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char o = s.toCharArray()[i];
            char r = t.toCharArray()[i];
            if (map.get(o) == null) {
                if (boolMap.get(r) == Boolean.TRUE) {
                    return false;
                }
                map.put(o, r);
                boolMap.put(r, true);
            } else if (map.get(o) != r)
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        isomorphic = new Solution2().isIsomorphic("badc", "bafv");
        System.out.println(isomorphic);
    }
}
