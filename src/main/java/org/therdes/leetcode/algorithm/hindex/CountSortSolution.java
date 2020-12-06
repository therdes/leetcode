package org.therdes.leetcode.algorithm.hindex;

public class CountSortSolution {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int citation : citations) {
            int processed = Math.min(citation, n);
            count[processed] += 1;
        }

        int[] sums = new int[n + 1];
        int k = 0;
        for (int i = sums.length - 1; i >= 0; --i) {
            k += count[i];
            if (i <= k) {
                return i;
            }
        }
        return 0;
    }
}
