package org.therdes.leetcode.algorithm.topkfrequentelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapSolution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> amount = new HashMap<>();
        for (int num : nums) {
            amount.put(num, amount.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : amount.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (entry.getValue() > queue.peek().getValue()) {
                queue.poll();
                queue.offer(entry);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
