package org.therdes.leetcode.algorithm.pascalstriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<Integer> first = new ArrayList<Integer>(1) {{
            add(1);
        }};
        List<List<Integer>> res = new ArrayList<List<Integer>>(numRows) {{
            add(first);
        }};
        if (numRows == 1) {
            return res;
        }

        for (int i = 1; i < numRows; ++i) {
            List<Integer> next = getTriangleRow(res.get(i - 1));
            res.add(next);
        }
        return res;
    }

    private List<Integer> getTriangleRow(List<Integer> prevRow) {
        int n = prevRow.size();
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[n] = 1;
        for (int i = 1; i < n; ++i) {
            nums[i] = prevRow.get(i - 1) + prevRow.get(i);
        }
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
}
