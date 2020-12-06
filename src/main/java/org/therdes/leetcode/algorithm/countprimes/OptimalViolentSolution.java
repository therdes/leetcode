package org.therdes.leetcode.algorithm.countprimes;

public class OptimalViolentSolution {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; ++i) {
            boolean isPrime = true;
            int max = (int) Math.floor(Math.sqrt(i));
            for (int j = 2; j <= max; ++j) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            count = isPrime ? count + 1 : count;
        }
        return count;
    }
}
