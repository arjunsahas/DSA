package com.arjun.algorithms.sorting;

import com.arjun.threads.TreeMap.TreeMap;
import java.util.*;

/** Created by arjuns on 7/6/17. */
public class Problem {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int _arr_size = 0;
    _arr_size = Integer.parseInt(in.nextLine().trim());
    int[] _arr = new int[_arr_size];
    int _arr_item;
    for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
      _arr_item = Integer.parseInt(in.nextLine().trim());
      _arr[_arr_i] = _arr_item;
    }

    customSort(_arr);
  }

  static void customSort(int[] arr) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < arr.length; i++) {
      Integer integer = map.get(arr[i]);
      if (integer == null) {
        map.put(arr[i], 1);
      } else {
        map.put(arr[i], integer + 1);
      }
    }
    System.out.println(map);

    List<Sam> sams = new ArrayList<>();
    for (Integer integer : map.keySet()) {
      Integer integer1 = map.get(integer);
      sams.add(new Sam(integer, integer1));
    }

    Collections.sort(
        sams,
        new Comparator<Sam>() {
          @Override
          public int compare(Sam o1, Sam o2) {
            if (o1.getFreq() < o2.getFreq()) {
              return 1;
            } else if (o1.getFreq() > o2.getFreq()) {
              return -1;
            } else if (o1.getFreq() == o2.getFreq()) {
              if (o1.getNum() > o1.getNum()) {
                return 1;
              } else if (o1.getNum() < o1.getNum()) {
                return -1;
              }
              return 0;
            }
            return 0;
          }
        });

    System.out.println(sams);
  }

  static class Sam {
    int num;
    int freq;

    public Sam(int num, int freq) {
      this.num = num;
      this.freq = freq;
    }

    public int getNum() {
      return num;
    }

    public void setNum(int num) {
      this.num = num;
    }

    public int getFreq() {
      return freq;
    }

    public void setFreq(int freq) {
      this.freq = freq;
    }

    @Override
    public String toString() {
      return String.valueOf(num);
    }
  }
}
