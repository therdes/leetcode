package org.therdes.leetcode.algorithm.ugly_number;

/**
 * @see <a href="https://leetcode-cn.com/problems/ugly-number/">263. 丑数</a>
 */
public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        int result = num;
        while (result % 2 == 0)
            result /= 2;
        while (result % 3 == 0)
            result /= 3;
        while (result % 5 == 0)
            result /= 5;
        return result == 1;
    }
}
