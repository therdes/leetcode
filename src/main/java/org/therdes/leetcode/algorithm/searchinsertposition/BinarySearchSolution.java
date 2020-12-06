package org.therdes.leetcode.algorithm.searchinsertposition;

public class BinarySearchSolution {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];
            if (target < num) {
                right = mid - 1;
            } else if (target > num) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
