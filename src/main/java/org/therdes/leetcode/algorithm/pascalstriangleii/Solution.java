package org.therdes.leetcode.algorithm.pascalstriangleii;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] nums = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; ++i) {
            nums[0] = 1;
            nums[i] = 1;
            int prevj = 1;
            int curj;
            for (int j = 1; j < i; ++j) {
                curj = nums[j];
                nums[j] = prevj + curj;
                prevj = curj;
            }
        }
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
}
