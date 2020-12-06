package org.therdes.leetcode.algorithm.minimumsizesubarraysum;

public class DoubleLoopSolution {

    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = i; j < n; ++j) {
                sum += nums[j];
                if (sum >= s) {
                    int length = j - i + 1;
                    min = Math.min(min, length);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
