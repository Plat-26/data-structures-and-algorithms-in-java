package algorithms.slidingwindow;

import java.util.*;

/**
 * Find all substrings of a string that contains all characters of another string.
 * In other words, find all substrings of the first string that are anagrams of the second string.
 */
public class AnagramFinder {

    public static void main(String[] args) {
        AnagramFinder finder = new AnagramFinder();
        List<String> anagrams = finder.findAnagrams("XYYZXZYZXXYZ", "XYZ");
        System.out.println(anagrams.toString());
        List<String> anagrams2 = finder.findAnagrams("ABCDBACCBAAB", "ABC");
        System.out.println(anagrams2.toString());
        List<String> anagrams3 = finder.findAnagrams("AB", "ABC");
        System.out.println(anagrams3.toString());

    }

    /**
     * Time: O(n * m)
     * Space O(n)
     * @param s1 where n = s1.length
     * @param s2 where m = s2.length
     * @return
     */
    public List<String> findAnagrams(String s1, String s2) {
        List<String> result = new ArrayList<>();

        //keep track of s2's structure
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s2.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        //keep track of the sliding window's state
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        for (int right = 0; right < s1.length(); right++) {
            int windowSize = right - left + 1;
            map.put(s1.charAt(right), map.getOrDefault(s1.charAt(right), 0) + 1);

            if (windowSize == s2.length()) {

                //compares the state of the window and s2 to determine if window is an anagram
                if (isSameContent(freq, map)) {
                    result.add(s1.substring(left, right + 1)); //get current window state as string
                }
                //update map and shrink window from left
                char charAtLeft = s1.charAt(left);
                map.put(charAtLeft, map.get(charAtLeft) - 1);
                left++;
            }
        }
        return result;
    }

    private boolean isSameContent(Map<Character, Integer> freq, Map<Character, Integer> windowState) {
        for (char c : freq.keySet()) {
            if (freq.get(c) != windowState.get(c)) {
                return false;
            }
        }
        return true;
    }
}
