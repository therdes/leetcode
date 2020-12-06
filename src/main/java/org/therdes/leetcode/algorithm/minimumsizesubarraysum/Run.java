package org.therdes.leetcode.algorithm.minimumsizesubarraysum;

public class Run {

    public static void main(String[] args) {
        SlidingWindowSolution solution = new SlidingWindowSolution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(solution.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.minSubArrayLen(20, new int[]{1, 2, 3, 4, 5}));
    }
}
