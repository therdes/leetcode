package org.therdes.leetcode.algorithm.backspacestringcompare;

public class SimulateBackspaceSolution {
    public boolean backspaceCompare(String S, String T) {
        String sp = removeBackspace(S);
        String tp = removeBackspace(T);
        return sp.equals(tp);
    }

    private String removeBackspace(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '#') {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1);
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
