package org.therdes.leetcode.algorithm.zuixiaodekgeshulcof;

import java.util.PriorityQueue;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> -1 * o1.compareTo(o2));
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                int top = queue.peek();
                if (num < top) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; ++i) {
            res[i] = queue.poll();
        }
        return res;
    }
}
