package com.arjun.leetcode.shortest_distance_821;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] shortestToChar(String s, char c) {
        int[] pos = new int[s.length()];
        List<Integer> cPosList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (c1 == c) {
                pos[i] = -1;
                cPosList.add(i);
            }
        }

        for (int i = 0; i < s.length(); i++) {

            if (pos[i] == -1) continue; // skip where 0 is marked.
            int minDistance = 0;
            for (Integer cPos : cPosList) {
                if (minDistance == 0) {
                    minDistance = Math.abs(i - cPos);
                } else
                    minDistance = Math.min(Math.abs(i - cPos), minDistance);
                pos[i] = minDistance;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (pos[i] == -1) pos[i] = 0;
        }

        return pos;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().shortestToChar("loveleetcode", 'e');
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
