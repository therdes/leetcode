package org.therdes.leetcode.algorithm.super_ugly_number;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);

        int num = 0;
        int count = 0;
        Set<Long> set = new HashSet<>();
        while (count < n) {
            num = queue.poll();
            count += 1;
            for (int prime : primes) {
                long res = (long) num * prime;
                if (!set.contains(res) && res <= Integer.MAX_VALUE) {
                    queue.add((int) res);
                    set.add(res);
                }
            }
        }
        return num;
    }
}
