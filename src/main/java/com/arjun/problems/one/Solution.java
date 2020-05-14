package com.arjun.problems.one;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] zeroArray = new long[n];
        for (int i = 0; i < queries.length; i++) {
            Integer a = queries[i][0];
            Integer b = queries[i][1];
            long k = queries[i][2];
            a = a - 1;
            b = b - 1;
            while (a <= b) {
                zeroArray[a] += k;
                a++;
            }
        }
        Arrays.sort(zeroArray);
        return zeroArray[n - 1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < queriesRowItems.length; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);
        scanner.close();
    }
}
