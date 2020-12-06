package org.therdes.leetcode.algorithm.findfirstandlastpositionofelementinsortedarray;

public class BinarySearchSolution {

    public int[] searchRange(int[] nums, int target) {
        int[] error = new int[]{-1, -1};
        int length = nums.length;
        if (length == 0) {
            return error;
        }
        if (target < nums[0] || target > nums[length - 1]) {
            return error;
        }

        int left = searchLeftIndex(nums, target);
        int right = searchRightIndex(nums, target);
        return left > right ? error : new int[]{left, right};
    }

    private int searchLeftIndex(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int searchRightIndex(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
