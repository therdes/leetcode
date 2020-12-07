package org.therdes.leetcode.algorithm.pascalstriangle;

import java.util.List;
import java.util.stream.Collectors;

public class Run {

    public static void main(String[] args) {
        Solution s = new Solution();
        show(s.generate(0));
        show(s.generate(1));
        show(s.generate(2));
        show(s.generate(3));
        show(s.generate(4));
        show(s.generate(5));
    }

    private static void show(List<List<Integer>> triangle) {
        System.out.println("[");
        int n = triangle.size();
        for (int i = 0; i < n; ++i) {
            System.out.printf("%" + (n - i) + "s", "");
            List<Integer> cur = triangle.get(i);
            String res = cur.stream().map(Object::toString).collect(Collectors.joining(","));
            System.out.printf("[%s],\n", res);
        }
        System.out.println("],");
    }
}
