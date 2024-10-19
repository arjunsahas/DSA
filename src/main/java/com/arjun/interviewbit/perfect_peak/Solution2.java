package com.arjun.interviewbit.perfect_peak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/perfect-peak-of-array/ The solution is a O(n2) solution.
 */
public class Solution1 {
    public int perfectPeak(ArrayList<Integer> A) {
        int isPerfectPeak = 0;

        List<Integer> minGroup = new ArrayList<>();
        List<Integer> maxGroup = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (i == 0) minGroup.add(A.get(i));
            else maxGroup.add(A.get(i));
        }

        int count = 0;
        for (int i = 1; i < A.size() - 1; i++) {

            int index = i - count - 1;
            Integer num = maxGroup.get(index);
            if (index < maxGroup.size())
                maxGroup.remove(index);

            int maxFromMinGroup = Collections.max(minGroup);
            int minFromMaxGroup = Collections.min(maxGroup);

            if (maxFromMinGroup < num && minFromMaxGroup > num) {
                isPerfectPeak = 1;
                break;
            } else {
                minGroup.add(num);
            }
            ++count;
        }

        return isPerfectPeak;
    }

    public static void main(String[] args) {
        int isPerfectPeak =
                new Solution1().perfectPeak(new ArrayList<>(Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9)));
        System.out.println(isPerfectPeak);

        isPerfectPeak = new Solution1().perfectPeak(new ArrayList<>(Arrays.asList(5, 1, 4, 4)));
        System.out.println(isPerfectPeak);

        isPerfectPeak = new Solution1().perfectPeak(new ArrayList<>(Arrays.asList(5706, 26963, 24465, 29359, 16828, 26501, 28146, 18468, 9962, 2996, 492, 11479, 23282, 19170, 15725, 6335)));
        System.out.println(isPerfectPeak);

        isPerfectPeak = new Solution1().perfectPeak(new ArrayList<>(Arrays.asList(9895, 30334, 17674, 23812, 20038, 25668, 6869, 1870, 4665, 27645, 7712, 17036, 31323, 8724, 28254, 28704, 26300, 25548, 15142, 12860, 19913, 32663, 32758)));
        System.out.println(isPerfectPeak);

    }
}
