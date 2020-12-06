package org.therdes.leetcode.algorithm.minimumsizesubarraysum;

public class SlidingWindowSolution {

    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int end = 0;
        int start = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            if (sum < s) {
                end += 1;
            } else {
                min = Math.min(min, end - start + 1);
                start += 1;
                sum -= nums[start - 1];
                sum -= nums[end];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
