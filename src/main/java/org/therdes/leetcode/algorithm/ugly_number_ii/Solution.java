package org.therdes.leetcode.algorithm.ugly_number_ii;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @see <a href="https://leetcode-cn.com/problems/ugly-number-ii/">264. 丑数 II</a>
 */
public class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);

        int num = 0;
        Set<Integer> set = new HashSet<>();
        while (set.size() < n) {
            num = queue.poll();
            set.add(num);
            queue.add(num * 2);
            queue.add(num * 3);
            queue.add(num * 5);
        }
        return num;
    }
}
