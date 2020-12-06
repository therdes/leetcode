package org.therdes.leetcode.algorithm.reorganizestring;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/reorganize-string/
 */
public class MaximumHeapSolution {

    static class CharacterAmount implements Comparable<CharacterAmount> {
        public CharacterAmount(char character, int amount) {
            this.character = character;
            this.amount = amount;
        }

        Character character;
        Integer amount;

        @Override
        public int compareTo(CharacterAmount o) {
            if (this.amount > o.amount)
                return -1;
            else if (this.amount < o.amount)
                return 1;
            else
                return character.compareTo(o.character);
        }
    }

    public String reorganizeString(String S) {
        int[] characterAmount = new int[26];
        int maxAmount = 0;
        for (int i = 0; i < S.length(); ++i) {
            int diffToStart = S.charAt(i) - 'a';
            characterAmount[diffToStart] += 1;
            maxAmount = Math.max(maxAmount, characterAmount[diffToStart]);
        }
        if (maxAmount > (S.length() + 1) / 2) {
            return "";
        }

        Queue<CharacterAmount> characterAmountQueue = new PriorityQueue<>(26);
        for (int i = 0; i < characterAmount.length; ++i) {
            if (characterAmount[i] != 0) {
                characterAmountQueue.offer(new CharacterAmount((char) (i + 'a'), characterAmount[i]));
            }
        }

        StringBuilder result = new StringBuilder();
        while (result.length() < S.length()) {
            CharacterAmount cur = characterAmountQueue.poll();
            if (cur == null) {
                return "";
            }
            if (result.length() != 0 && result.charAt(result.length() - 1) == cur.character) {
                CharacterAmount next = characterAmountQueue.poll();
                if (next == null) {
                    return "";
                }
                result.append(next.character);
                next.amount -= 1;
                result.append(cur.character);
                cur.amount -= 1;
                if (cur.amount > 0) {
                    characterAmountQueue.offer(cur);
                }
                if (next.amount > 0) {
                    characterAmountQueue.offer(next);
                }
            } else {
                result.append(cur.character);
                cur.amount -= 1;
                if (cur.amount > 0) {
                    characterAmountQueue.offer(cur);
                }
            }
        }

        return result.toString();
    }
}
