package org.therdes.leetcode.algorithm.splitarrayintoconsecutivesubsequences;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    public boolean isPossible(int[] nums) {
        if (nums.length <= 2)
            return false;
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        while (!list.isEmpty()) {
            if (!findConsecutiveSubsequences(list))
                return false;
        }
        return true;
    }

    private boolean findConsecutiveSubsequences(List<Integer> nums) {
        ListIterator<Integer> iter = nums.listIterator();
        List<Integer> seq = new ArrayList<>();
        while (iter.hasNext()) {
            int cur = iter.next();
            if (seq.isEmpty()) {
                seq.add(cur);
                iter.remove();
            } else if (seq.get(seq.size() - 1) == (cur - 1)) {
                seq.add(cur);
                iter.remove();
            }
        }
        return seq.size() >= 3;
    }
}
