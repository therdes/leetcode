package org.therdes.leetcode.algorithm.backspacestringcompare;

public class ReverseTraversalSolution {
    public boolean backspaceCompare(String S, String T) {
        int sn = S.length();
        int tn = T.length();
        int si = sn - 1;
        int ti = tn - 1;

        int shashkey = 0;
        int thashkey = 0;

        while (si >= 0 && ti >= 0) {
            char sc = S.charAt(si);
            char tc = T.charAt(ti);

            if (sc == '#') {
                shashkey += 1;
                si -= 1;
            } else if (tc == '#') {
                thashkey += 1;
                ti -= 1;
            } else if (shashkey > 0) {
                shashkey -= 1;
                si -= 1;
            } else if (thashkey > 0) {
                thashkey -= 1;
                ti -= 1;
            } else if (sc == tc) {
                si -= 1;
                ti -= 1;
            } else {
                return false;
            }
        }

        if (si < 0 && ti < 0) {
            return true;
        }

        String K = si >= 0 ? S : T;
        int ki = si >= 0 ? si : ti;
        int khashkey = si >= 0 ? shashkey : thashkey;
        while (ki >= 0) {
            char kc = K.charAt(ki);
            if (kc == '#') {
                khashkey += 1;
                ki -= 1;
            } else if (khashkey > 0) {
                khashkey -= 1;
                ki -= 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
