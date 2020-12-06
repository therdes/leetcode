package org.therdes.leetcode.algorithm.hindex;

public class Run {

    public static void main(String[] args) {
        CountSortSolution s = new CountSortSolution();
        System.out.println(s.hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(s.hIndex(new int[]{1, 1, 1, 1, 1}));
        System.out.println(s.hIndex(new int[]{0, 0, 0}));
    }
}
