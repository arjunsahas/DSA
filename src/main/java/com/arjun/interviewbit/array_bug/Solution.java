package com.arjun.interviewbit.array_bug;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        if (B >= A.size()) B = B % A.size();
        ArrayList<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {
            if (i + B >= A.size()) break;
            ret.add(A.get(i + B));
        }
        for (int i = 0; i < B; i++) {
            ret.add(A.get(i));
        }
        return ret;
    }

    public ArrayList<Integer> rotateArray1(ArrayList<Integer> A, int B) {
        if (B >= A.size()) B = B % A.size();
        ArrayList<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {
            if (i + B >= A.size()) ret.add(A.get(i + B - A.size()));
            else ret.add(A.get(i + B));
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        ArrayList<Integer> integers = new Solution().rotateArray(a, 3);
        System.out.println(integers);

        integers = new Solution().rotateArray(a, 4);
        System.out.println(integers);

        integers = new Solution().rotateArray(a, 5);
        System.out.println(integers);

        integers = new Solution().rotateArray1(a, 3);
        System.out.println(integers);

        integers = new Solution().rotateArray1(a, 4);
        System.out.println(integers);

        integers = new Solution().rotateArray1(a, 5);
        System.out.println(integers);
    }
}
