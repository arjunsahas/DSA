package com.arjun.leetcode._90_subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/** https://leetcode.com/problems/subsets-ii/ */
class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<Integer> numsList = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      numsList.add(nums[i]);
    }
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    subsets(numsList, subsets, new ArrayList<>(), 0);
    return subsets;
  }

  private void subsets(
      List<Integer> numsList, List<List<Integer>> subsets, List<Integer> workingList, int start) {
    if (!subsets.contains(workingList)) {
      subsets.add(new ArrayList<>(workingList));
    }
    for (int i = start; i < numsList.size(); i++) {
      workingList.add(numsList.get(i));
      subsets(numsList, subsets, workingList, i + 1);
      workingList.remove(workingList.size() - 1);
    }
  }

  private void subsets(List<Integer> numsList, List<List<Integer>> subsets, int start, int end) {
    if (numsList.size() == 0) return;
    addIfUnique(numsList, subsets);
    if (isaBoolean(numsList, start, end)) {
      subsets(numsList.subList(start, end), subsets, start, --end);
      end++;
    }
    if (isaBoolean(numsList, start, end)) {
      subsets(numsList.subList(start, end), subsets, ++start, end);
    }
  }

  private boolean isaBoolean(List<Integer> numsList, int start, int end) {
    return start <= end
        && start <= numsList.size()
        && end <= numsList.size()
        && start >= 0
        && end >= 0;
  }

  private void addIfUnique(List<Integer> incomingSubset, List<List<Integer>> existingSubsets) {
    List<Integer> numListNew = new ArrayList<>(incomingSubset);

    boolean uniqueForEntireSet = true;

    if (incomingSubset.size() == 0) uniqueForEntireSet = false;
    for (List<Integer> existingSubset : existingSubsets) {
      boolean isContains = false;
      if (existingSubset.size() == incomingSubset.size()) {
        Iterator<Integer> iterator = existingSubset.iterator();
        // check if the incoming subset is a duplicate each subset already present.
        while (iterator.hasNext()) {
          Integer next = iterator.next();
          isContains = numListNew.contains(next);
          if (!isContains) break;
          numListNew.remove(next);
        }
      }
      // admit only if it matches otherwise there is no need
      if (isContains) {
        uniqueForEntireSet = uniqueForEntireSet & !isContains;
        break;
      }
    }
    if (uniqueForEntireSet) existingSubsets.add(incomingSubset);
  }

  public static void main(String[] args) {
    List<List<Integer>> lists = new Solution().subsetsWithDup(new int[] {1, 2, 2});
    System.out.println(lists);

    lists = new Solution().subsetsWithDup(new int[] {1, 2, 2, 4, 5, 6});
    System.out.println(lists);

    lists = new Solution().subsetsWithDup(new int[] {0});
    System.out.println(lists);
  }
}
