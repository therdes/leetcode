package org.therdes.leetcode.algorithm.sortcharactersbyfrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 哈希表计算频率后使用堆排序
 *
 * @see <a href="https://leetcode-cn.com/problems/sort-characters-by-frequency/">451. 根据字符出现频率排序</a>
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> amount = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            amount.put(c, amount.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(Math.max(amount.size(), 1),
            Map.Entry.comparingByValue());
        amount.entrySet().forEach(queue::offer);
        
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i = 0; i < entry.getValue(); ++i) {
                res.append(entry.getKey());
            }
        }
        return res.reverse().toString();
    }
}
