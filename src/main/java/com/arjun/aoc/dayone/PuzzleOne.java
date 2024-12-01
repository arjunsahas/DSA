package com.arjun.aoc.dayone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PuzzleOne {

  public static void main(String[] args) throws IOException {
    List<String> lines =
        Files.readAllLines(Path.of("./src/main/java/com/arjun/aoc/dayone/input.txt"));
    List<Integer> firstList = new ArrayList<>();
    List<Integer> secondList = new ArrayList<>();

    for (String line : lines) {
      String[] s = line.split("   ");
      firstList.add(Integer.valueOf(s[0]));
      secondList.add(Integer.valueOf(s[1]));
    }

    firstList.sort(Comparator.naturalOrder());
    secondList.sort(Comparator.naturalOrder());

    int total = 0;
    for (int i = 0; i < lines.size(); i++) {
      total += Math.abs(firstList.get(i) - secondList.get(i));
    }
    System.out.println(total);
  }
}
