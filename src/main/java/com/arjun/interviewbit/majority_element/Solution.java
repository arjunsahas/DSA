package com.arjun.interviewbit.majority_element;

import java.util.*;

/**
 * Given an array of size N, find the majority element. The majority element is the element that appears more than floor(N/2) times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {
        if(A.length == 1) return A[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            if (map.get(val) == null) {
                map.put(val, 1);
            } else {
                map.put(val, map.get(val) + 1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if(Objects.equals(o1.getValue(), o2.getValue())) return 0;
            else return o1.getValue() > o2.getValue() ? 1: -1;

        });
        if (!list.isEmpty()) {
            Map.Entry<Integer,Integer> i = list.get(list.size() - 1);
            if (i.getValue() > Math.floor((double) A.length / 2)) return i.getKey();

        }

        return A[A.length - 1];
    }

    public static void main(String[] args) {
        int i = new Solution().majorityElement(new int[]{1, 2, 3, 3, 3});
        System.out.println(i);

        i = new Solution().majorityElement(new int[]{1, 2, 3, 3, 2});
        System.out.println(i);

        i = new Solution().majorityElement(new int[]{100});
        System.out.println(i);

        i = new Solution().majorityElement(new int[]{1, 1, 2});
        System.out.println(i);
    }
}
