package org.therdes.leetcode.algorithm.findfirstandlastpositionofelementinsortedarray;

import java.util.Arrays;

public class Run {

    public static void main(String[] args) {
        BinarySearchSolution solution = new BinarySearchSolution();
        Arrays.stream(solution.searchRange(new int[]{5, 7, 7, 8, 10}, 1))
            .forEach(System.out::println);
        Arrays.stream(solution.searchRange(new int[]{5, 7, 7, 8, 10}, 5))
            .forEach(System.out::println);
        Arrays.stream(solution.searchRange(new int[]{5, 7, 7, 8, 10}, 7))
            .forEach(System.out::println);
        Arrays.stream(solution.searchRange(new int[]{5, 7, 7, 8, 10}, 8))
            .forEach(System.out::println);
        Arrays.stream(solution.searchRange(new int[]{5, 7, 7, 8, 10}, 10))
            .forEach(System.out::println);
        Arrays.stream(solution.searchRange(new int[]{5, 7, 7, 8, 10}, 20))
            .forEach(System.out::println);
        Arrays.stream(solution.searchRange(new int[]{5, 7, 7, 8, 10}, 6))
            .forEach(System.out::println);
        Arrays.stream(solution.searchRange(new int[]{5, 7, 7, 8, 10}, 9))
            .forEach(System.out::println);
    }
}
