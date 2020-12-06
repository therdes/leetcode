package org.therdes.leetcode.algorithm.squaresofasortedarray;

import java.util.stream.IntStream;

public class DoublePointerSolution {

    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];

        int k = A.length - 1;
        int i = 0, j = A.length - 1;
        while (k >= 0) {
            int a = A[i];
            int b = A[j];
            int a2 = a * a;
            int b2 = b * b;
            if (a2 > b2) {
                result[k] = a2;
                i++;
            } else {
                result[k] = b2;
                j--;
            }
            k--;
        }
        return result;
    }
}
