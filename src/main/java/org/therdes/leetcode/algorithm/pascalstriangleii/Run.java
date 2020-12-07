package org.therdes.leetcode.algorithm.pascalstriangleii;

import java.util.stream.Collectors;

public class Run {

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i <= 20; ++i) {
            System.out.printf("[%s]\n",
                s.getRow(i).stream().map(Object::toString).collect(Collectors.joining(",")));
        }
    }
}
