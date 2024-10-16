package com.arjun.interviewbit.occurance_each_number;

import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given an integer array A.
 * <p>
 * You have to find the number of occurences of each number.
 * <p>
 * Return an array containing only the occurences with the smallest value's occurence first.
 * <p>
 * For example, A = [4, 3, 3], you have to return an array [2, 1], where 2 is the number of occurences for element 3,
 * and 1 is the number of occurences for element 4. But, 2 comes first because 3 is smaller than 4.
 */
public class Solution {
    public ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer i : A) {
            if (!countMap.containsKey(i)) {
                countMap.put(i, 1);
            } else countMap.put(i, countMap.get(i) + 1);
        }
        List<Map.Entry<Integer, Integer>> countList = new ArrayList<>(countMap.entrySet());
        countList.sort((o1, o2) -> {
            if (Objects.equals(o1.getKey(), o2.getKey())) return 0;
            return o1.getKey() > o2.getKey() ? 1 : -1;
        });
        List<Integer> collect = countList.stream().map(Map.Entry::getValue).collect(Collectors.toList());
        return new ArrayList<>(collect);
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(4);
        integers.add(1);
        ArrayList<Integer> occurrences = new Solution().findOccurences(integers);
        System.out.println(occurrences);

        integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        occurrences = new Solution().findOccurences(integers);
        System.out.println(occurrences);

        integers = new ArrayList<>();
        integers.add(122);
        integers.add(122);
        integers.add(3);
        integers.add(3);
        integers.add(3);
        integers.add(3);
        integers.add(7);
        integers.add(7);
        occurrences = new Solution().findOccurences(integers);
        System.out.println(occurrences);
    }
}
