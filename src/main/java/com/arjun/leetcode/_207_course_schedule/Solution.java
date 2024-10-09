package com.arjun.leetcode._207_course_schedule;

import java.util.*;

/** https://leetcode.com/problems/course-schedule/ */
class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Node[] adjacencyList = createAdjacencyList(numCourses, prerequisites);
    printAdjacencyList(adjacencyList);
    Boolean[] resultForTraversal = new Boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      resultForTraversal[i] = bfs(adjacencyList, i);
    }

    Optional<Boolean> reduce =
        Arrays.stream(resultForTraversal).reduce((aBoolean, aBoolean2) -> aBoolean && aBoolean2);
    return reduce.get();
  }

  // number of courses are the vertices

  private Node[] createAdjacencyList(int numCourses, int[][] prerequisites) {
    Node[] adjacencyList = new Node[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      int startVertex = prerequisites[i][0];
      int endVertex = prerequisites[i][1];
      //            addVertexToAdjacencyList(adjacencyList, startVertex, endVertex);
      addVertexToAdjacencyList(adjacencyList, endVertex, startVertex);
    }
    return adjacencyList;
  }

  private void addVertexToAdjacencyList(Node[] adjacencyList, int startVertex, int endVertex) {
    if (adjacencyList[startVertex] == null) {
      adjacencyList[startVertex] = new Node(endVertex);
    } else {
      Node n = adjacencyList[startVertex];
      while (n.next != null) {
        n = n.next;
      }
      n.next = new Node(endVertex);
    }
  }

  private void printAdjacencyList(Node[] adjacencyList) {
    for (int i = 0; i < adjacencyList.length; i++) {
      System.out.print("Vertex " + i + " - > ");
      Node n = adjacencyList[i];
      while (n != null) {
        System.out.print(" " + n.number);
        n = n.next;
      }
      System.out.println("\n");
    }
  }

  private boolean bfs(Node[] adjacencyList, int randomStartVertex) {
    System.out.println("Run " + randomStartVertex);
    Queue<Node> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    Node startNode = adjacencyList[randomStartVertex];
    if (startNode != null) queue.add(startNode);
    while (!queue.isEmpty()) {
      Node n = queue.poll();
      if (visited.contains(n.number)) {
        System.out.println(n.number + " already visited");
        return false;
      } else visited.add(n.number);
      System.out.println(n.number + " visited ");
      Node connection = adjacencyList[n.number];
      if (connection != null) {
        while (connection != null && !visited.contains(connection.number)) {
          queue.add(connection);
          connection = connection.next;
        }
      }
    }
    return true;
  }

  static class Node {
    int number;
    Node next;

    Node() {
      next = null;
    }

    Node(int number) {
      this.number = number;
      next = null;
    }
  }

  public static void main(String[] args) {

    boolean b =
        new Solution()
            .canFinish(
                7, new int[][] {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}});
    System.out.println(b);

    //         b = new Solution().canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}});
    //        System.out.println(b);

    //        b = new Solution().canFinish(1, new int[][]{{0, 0}});
    //        System.out.println(b);
    //
    //        b = new Solution().canFinish(6, new int[][]{{0, 1}, {2, 1}, {1, 2}, {2, 3}, {3, 4},
    // {4, 5}});
    //        System.out.println(b);
    //
    //        b = new Solution().canFinish(2, new int[][]{{1, 0}});
    //        System.out.println(b);
    //
    //        b = new Solution().canFinish(2, new int[][]{{1, 0}, {0, 1}});
    //        System.out.println(b);
    //
    //        b = new Solution().canFinish(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11,
    // 14}, {13, 1}, {15, 1}, {17, 4}});
    //        System.out.println(b);

  }
}
