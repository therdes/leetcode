package org.therdes.leetcode.algorithm.kthlargestelementinanarray;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class HeapSolution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num > queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.poll();
    }
}
