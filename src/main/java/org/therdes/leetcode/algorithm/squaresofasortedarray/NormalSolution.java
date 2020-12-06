package org.therdes.leetcode.algorithm.squaresofasortedarray;

import java.util.stream.IntStream;

public class NormalSolution {

    public int[] sortedSquares(int[] A) {
        return IntStream.of(A).map(Math::abs).sorted()
            .map(num -> num * num)
            .toArray();
    }
}
