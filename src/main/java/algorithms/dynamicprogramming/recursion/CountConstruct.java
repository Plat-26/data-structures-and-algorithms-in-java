package algorithms.dynamicprogramming.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function countConstruct(target wordBank) that accepts a target String and an array of Strings.
 * The function should return the number of ways that the target can be constructed by concatenating elements
 * of the word bank array.
 */
public class CountConstruct {

    public static void main(String[] args) {
        CountConstruct countConstruct = new CountConstruct();
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        System.out.println(countConstruct.countConstruct("abcdef", wordBank));

        String[] wordBank2 = {"purp", "p", "ur", "le", "purpl"};
        System.out.println(countConstruct.countConstruct("purple", wordBank2));

        String[] wordBank3 = {"e", "ee", "eee", "eeee", "eeeee"};
        System.out.println(countConstruct
                .countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                        wordBank2, new HashMap<>()));
    }

    /**
     * BRUTE FORCE
     * m = target.length
     * n = wordBank.length
     * Time = O(m ^n * m)
     * Space = O(m * m)
     * @param target
     * @param wordBank
     * @return
     */
    public int countConstruct(String target, String[] wordBank) {
        if ("".equals(target)) {
            return 1;
        }

        int totalCount = 0;
        for(String word : wordBank) {
            if(target.startsWith(word)) {
                String suffix = target.replaceAll(word, "");
                int count = countConstruct(suffix, wordBank);
                totalCount += count;
            }
        }
        return totalCount;
    }

    /**
     *
     * @param target
     * @param wordBank
     * @return
     */
    public int countConstruct(String target, String[] wordBank, Map<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if ("".equals(target)) {
            return 1;
        }

        int totalCount = 0;
        for(String word : wordBank) {
            if(target.startsWith(word)) {
                String suffix = target.replaceAll(word, "");
                int count = countConstruct(suffix, wordBank, memo);
                totalCount += count;
            }
        }
        memo.put(target, totalCount);
        return totalCount;
    }
}
