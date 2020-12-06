package org.therdes.leetcode.algorithm.countprimes;

public class Run {

    public static void main(String[] args) {
        ViolentSolution solution = new ViolentSolution();
        System.out.println(solution.countPrimes(10));
        System.out.println(solution.countPrimes(0));
        System.out.println(solution.countPrimes(499979));
    }
}
