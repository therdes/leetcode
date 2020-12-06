package org.therdes.leetcode.algorithm.findfirstandlastpositionofelementinsortedarray;

public class DoublePointerSolution {

    public int[] searchRange(int[] nums, int target) {
        int[] error = new int[]{-1, -1};
        int length = nums.length;
        if (length == 0) {
            return error;
        }
        if (target < nums[0] || target > nums[length - 1]) {
            return error;
        }

        int i = 0, j = length - 1;
        while (i < j) {
            if (nums[i] != target) {
                i++;
            }
            if (nums[j] != target) {
                j--;
            }
            if (nums[i] == target && nums[j] == target) {
                return new int[]{i, j};
            }
        }
        return nums[i] == target ? new int[]{i, j} : error;
    }
}
