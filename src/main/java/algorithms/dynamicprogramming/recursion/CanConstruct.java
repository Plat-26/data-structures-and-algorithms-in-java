package algorithms.dynamicprogramming.recursion;

import java.util.Map;

/**
 * Write a function canConstruct that accepts a target string and an array of strings.
 * The function should return a boolean that indicates weather or not the target can be constructed by
 * concatenating elements of the word bank array.
 */
public class CanConstruct {

    public static void main(String[] args) {
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        CanConstruct can = new CanConstruct();
        System.out.println(can.canConstruct("abcdef", wordBank));
    }

    /**
     * n - length of wordBank
     * m - length of target String
     * Time: O(n ^ m * m)
     * Space: O(m ^ 2)
     * @param target
     * @param wordBank
     * @return
     */
    public boolean canConstruct(String target, String[] wordBank) {
        if ("".equals(target)) {
            return true;
        }

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.replaceFirst(word, "");
                if(canConstruct(suffix, wordBank)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * n = length of wordBank, input array
     * m = length of String
     * Time: O(n *m ^2)
     * Space: O(m^2)
     * @param target
     * @param wordBank
     * @param memo
     * @return
     */
    public boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if ("".equals(target)) {
            return true;
        }

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.replaceFirst(word, "");
                if(canConstruct(suffix, wordBank, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }
}
