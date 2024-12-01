package com.arjun.leetcode.chemical_compound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

  // Have a list compounds as tokens. This is required as the program will not be able to identify
  // and separate the compounds without these.
  private static Map<String, String> COMPOUND_MAP =
      Map.of(
          "H", "H", "C", "C", "O", "O", "Li", "Li", "Na", "Na", "Cl", "Cl", "Co", "Co", "S", "S",
          "Ca", "Ca");

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("H2O");
    strings.add("O2");
    strings.add("C6H12");
    strings.add("COOH");
    strings.add("Li2SO4");
    strings.add("H2SO4");
    strings.add("NaCl");
    strings.add("CH3COOH");
    strings.add("CoO");
    strings.add("Co2O3");
    strings.add("Co3O4");
    strings.add("CaCO3");

    for (String string : strings) {
      Map<String, Integer> compounds = processCompound1(string);
      System.out.println("Compound: " + string);
      System.out.print("{ ");
      int count = 0;
      for (Map.Entry<String, Integer> entry : compounds.entrySet()) {
        System.out.print("\"" + entry.getKey() + "\" : " + entry.getValue());
        if (count != compounds.size() - 1) System.out.print(", ");
        count++;
      }
      System.out.println(" }");
    }
  }

  // iterate push till you encounter a letter after a digit
  // or push till you reach the end of string.

  private static Map<String, Integer> processCompound1(String compound) {
    Map<String, Integer> compoundVsOccurances = new HashMap<>();
    Stack<Character> stack = new Stack<>();
    int index = 0;
    while (index < compound.length()) {
      char c = compound.charAt(index);

      if (!stack.empty() && Character.isLetter(c) && Character.isDigit(stack.peek())) {
        popOccurances(stack, compoundVsOccurances);
      }
      stack.push(c);
      index++;
    }
    popOccurances(stack, compoundVsOccurances);
    return compoundVsOccurances;
  }

  private static void put(
      Map<String, Integer> compoundVsOccurances, String compound, Integer occurance) {
    if (compoundVsOccurances.get(compound) != null) {
      compoundVsOccurances.put(compound, compoundVsOccurances.get(compound) + occurance);
    } else {
      compoundVsOccurances.put(compound, occurance);
    }
  }

  private static void popOccurances(
      Stack<Character> stack, Map<String, Integer> compoundVsOccurances) {
    StringBuilder number = new StringBuilder();
    StringBuilder compounds = new StringBuilder();
    while (!stack.isEmpty()) {
      char c1 = stack.pop();
      if (Character.isDigit(c1)) number.insert(0, c1);
      if (Character.isLetter(c1)) {
        compounds.insert(0, c1);
        String cmp = COMPOUND_MAP.get(compounds.toString());
        if (cmp != null) {
          put(
              compoundVsOccurances,
              cmp,
              number.toString().isEmpty() ? 1 : Integer.valueOf(number.toString()));
          number.delete(0, number.length());
          compounds.delete(0, compounds.length());
        }
      }
    }
  }
}
