package org.therdes.leetcode.algorithm.kthlargestelementinastream;

import java.util.PriorityQueue;

public class KthLargest {

    private final PriorityQueue<Integer> queue;

    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else {
            int top = queue.peek();
            if (val > top) {
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }
}
