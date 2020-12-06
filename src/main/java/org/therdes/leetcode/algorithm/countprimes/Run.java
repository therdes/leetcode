package org.therdes.leetcode.algorithm.countprimes;

public class Run {

    public static void main(String[] args) {
        OptimalViolentSolution solution = new OptimalViolentSolution();
        System.out.println(solution.countPrimes(10));
        System.out.println(solution.countPrimes(0));
        System.out.println(solution.countPrimes(499979));
    }
}
