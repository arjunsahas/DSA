package com.arjun.aoc.dayone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PuzzleTwo {

  public static void main(String[] args) throws IOException {
    List<String> lines =
        Files.readAllLines(Path.of("./src/main/java/com/arjun/aoc/dayone/input.txt"));
    List<Integer> firstList = new ArrayList<>();
    Map<Integer, Integer> secondMapWithRepeats = new HashMap<>();

    for (String line : lines) {
      String[] s = line.split("   ");
      firstList.add(Integer.valueOf(s[0]));
      Integer key = Integer.valueOf(s[1]);
      secondMapWithRepeats.merge(key, 1, Integer::sum);
    }

    int totalSimilarityScore = 0;
    for (int i = 0; i < lines.size(); i++) {
      Integer search = firstList.get(i);
      totalSimilarityScore +=
          search
              * (secondMapWithRepeats.get(search) != null ? secondMapWithRepeats.get(search) : 0);
    }
    System.out.println(totalSimilarityScore);
  }
}
