package com.arjun.interviewbit.array_sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * The trick here is that the input arrays can be of different sizes and since they are of different
 * sizes we need to have different pointers which starts at different indexes and stops at different
 * indexes.
 */
public class Solution {
  public ArrayList<Integer> addArrays(ArrayList<Integer> A, ArrayList<Integer> B) {
    int carryForward = 0;
    int arraySize = 0;
    if (A.size() == B.size()) {
      arraySize = A.size() + 1;
    } else arraySize = Math.max(A.size(), B.size());
    ArrayList<Integer> sumList = new ArrayList<>(arraySize);
    for (int i = 0; i < arraySize; i++) {
      sumList.add(0);
    }
    int aPointer = A.size() - 1;
    int bPointer = B.size() - 1;
    for (int i = arraySize - 1; i >= 0; i--) {
      Integer i1 = 0;
      if (aPointer >= 0) i1 = A.get(aPointer);
      aPointer--;

      Integer i2 = 0;
      if (bPointer >= 0) i2 = B.get(bPointer);
      bPointer--;
      int sum = carryForward + i1 + i2;
      if (sum >= 10) {
        sumList.set(i, sum % 10);
        carryForward = 1;
      } else {
        carryForward = 0;
        sumList.set(i, sum);
      }
    }
    Optional<Integer> first = sumList.stream().findFirst();
    if (first.isPresent() && first.get() == 0) {
      return new ArrayList<>(sumList.subList(1, sumList.size()));
    }
    return sumList;
  }

  public static void main(String[] args) {
    ArrayList<Integer> sumList =
        new Solution()
            .addArrays(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
                new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6)));
    System.out.println(sumList);

    sumList =
        new Solution()
            .addArrays(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)),
                new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6)));
    System.out.println(sumList);

    sumList =
        new Solution()
            .addArrays(
                new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9)),
                new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9)));
    System.out.println(sumList);
  }
}
