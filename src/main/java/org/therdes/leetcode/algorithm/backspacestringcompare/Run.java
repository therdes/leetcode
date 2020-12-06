package org.therdes.leetcode.algorithm.backspacestringcompare;

public class Run {

    public static void main(String[] args) {
        ReverseTraversalSolution s = new ReverseTraversalSolution();
        System.out.println(s.backspaceCompare("ab#c", "ad#c"));
        System.out.println(s.backspaceCompare("ab##", "c#d#"));
        System.out.println(s.backspaceCompare("a##c", "#a#c"));
        System.out.println(s.backspaceCompare("a#c", "b"));
        System.out.println(s.backspaceCompare("bxj##tw", "bxo#j##tw"));
        System.out.println(s.backspaceCompare("nzp#o#g", "b#nzp#o#g"));
    }
}
