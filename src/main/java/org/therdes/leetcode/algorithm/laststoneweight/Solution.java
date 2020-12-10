package org.therdes.leetcode.algorithm.laststoneweight;

import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, (o1, o2) -> -1 * o1.compareTo(o2));
        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int one = queue.poll();
            int two = queue.poll();
            int diff = Math.abs(one - two);
            if (diff > 0) {
                queue.offer(diff);
            }
        }

        return queue.size() == 1 ? queue.peek() : 0;
    }
}
