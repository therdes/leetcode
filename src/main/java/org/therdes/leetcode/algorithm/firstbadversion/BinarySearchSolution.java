package org.therdes.leetcode.algorithm.firstbadversion;

public class BinarySearchSolution extends VersionControl {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean bad = isBadVersion(mid);
            if (bad) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
