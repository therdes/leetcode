package org.therdes.leetcode.algorithm.reorganizestring;

public class Run {

    public static void main(String[] args) {
        // a:10 b:9 c:6 d:2
        System.out.println("1:" + new MaximumHeapSolution().reorganizeString("aaaaaaaaaabbbbbbbbbccccccdd"));
        // a:2 b:2 c:5
        System.out.println("2:" + new MaximumHeapSolution().reorganizeString("aabbccccc"));
    }
}
