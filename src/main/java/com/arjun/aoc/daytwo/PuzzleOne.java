package com.arjun.aoc.daytwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PuzzleOne {

  public static void main(String[] args) throws IOException {
    List<String> lines =
        Files.readAllLines(Path.of("./src/main/java/com/arjun/aoc/daytwo/report.txt"));

    int safeCount = 0;
    for (String line : lines) {
      String[] levels = line.split(" ");
      int previousLevel = -1;
      boolean decrease = false;
      boolean safe = true;
      for (int i = 0; i < levels.length; i++) {
        int l = Integer.parseInt(levels[i]);
        if (i == 0) {
          previousLevel = l;
          continue;
        }
        if (i == 1) {
          decrease = l < previousLevel;
        }
        if (l < previousLevel) {
          if (decrease != l < previousLevel) {
            safe = false;
            break;
          }
          if (getSafeCount(l, previousLevel)) {
            safe = true;
          } else {
            safe = false;
            break;
          }
        } else {
          if (decrease == l > previousLevel) {
            safe = false;
            break;
          }
          if (getSafeCount(l, previousLevel)) {
            safe = true;
          } else {
            safe = false;
            break;
          }
        }
        previousLevel = l;
      }
      if (safe) safeCount++;
    }
    System.out.println(safeCount);
  }

  private static boolean getSafeCount(int l, int previousLevel) {
    int diff = Math.abs(l - previousLevel);
    if (diff >= 1 && diff <= 3) {
      return true;
    }
    return false;
  }
}
