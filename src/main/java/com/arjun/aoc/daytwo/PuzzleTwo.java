package com.arjun.aoc.daytwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * The question is same as puzzle one except for problem dampener. We can tolerate single bad level.
 * For a number, the number behind or ahead can be a problem. This needs to be considered.
 */
public class PuzzleTwo {

  public static void main(String[] args) throws IOException {
    List<String> lines =
        Files.readAllLines(Path.of("./src/main/java/com/arjun/aoc/daytwo/report1.txt"));

    int safeCount = 0;
    for (int j = 0; j < lines.size(); j++) {
      String line = lines.get(j);
      String[] levels = line.split(" ");

      int previousLevel = -1;
      int currentLevel = -1;
      int nextLevel = -1;

      boolean decrease = false;
      boolean safe = true;
      int badLevel = 0; // tolerate one bad level.

      for (int i = 0; i < levels.length; i++) {
        boolean badLevelBool = false;
        int level = Integer.parseInt(levels[i]);
        if (i == 0) { // assign first number to previousLevel
          previousLevel = level;
          continue;
        }
        if (i == 1) { // find the progression whether increase or decrease.
          decrease = level < previousLevel;
        }
        boolean isSafeCount = getSafeCount(level, previousLevel); // adjacent levels <=3 and > 1
        if (!isSafeCount) {
          if (badLevel < 1) {
            badLevel++;
            badLevelBool = true;
            System.out.println(j);
          } else {
            safe = false;
            break;
          }
        }
        if (level < previousLevel) {
          if (decrease != level < previousLevel) {
            if (badLevel < 1) {
              badLevel++;
              badLevelBool = true;
              System.out.println(j);
            } else {
              safe = false;
              break;
            }
          }
        } else {
          if (decrease == level > previousLevel) {
            if (badLevel < 1) {
              badLevel++;
              badLevelBool = true;
              System.out.println(j);
            } else {
              safe = false;
              break;
            }
          }
        }
        if (!badLevelBool) previousLevel = level;
      }
      if (safe && badLevel <= 1) safeCount++;
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
