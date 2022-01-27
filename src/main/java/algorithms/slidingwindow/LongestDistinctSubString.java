package algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring
 * that contains no more than k distinct characters.
 */
public class LongestDistinctSubString {

    public static void main(String[] args) {
        LongestDistinctSubString longest = new LongestDistinctSubString();
        int length = longest.findLongestSubString("abcbdbdbbdcdabd", 3);
        System.out.println(length);

        int length2 = longest.findLongestSubString("aabccccbbcef", 2);
        System.out.println(length2);
    }
    public int findLongestSubString(String s, int k) {
        //aabccccbbcef  k = 2 == bccccbbc

        //int maxLength =
        //create a Map to contain current distinct characters and their count
        //map = [bc]
        //initialize the window left = 0, right = 0
        //loop with right side of window up to s.length
        // if (map.size < k || map.contains(s.charAt(right))
        //  map.put(s.charAt(right), map.getOrDefault(s.charAt(i), 0)++)
        //  maxLength++
        // if (map.size >= k && !s.contains(s.charAt(right))
        //  temp = s.charAt(left)
        //  count = map.get(s.charAt(left))
        //  while (count > 0) {
        //    left++;
        //  }
        //  int currLength = right - left + 1;
        //  max = max.length > currentLength ? max : currentLength
        //  map.deleteKey(temp)
        //  left = right;
        //  temp = " "

        //abcbdbdbbdcdabd k = 4
        int maxLength = Integer.MIN_VALUE; // 3
        Map<Character, Integer> map = new HashMap<>(); // { a - 1, b - 2, c - 1}
        int left = 0; //
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            if (map.size() <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            if (map.size() > k) {
                char excess = s.charAt(left); //
                int count = map.get(s.charAt(left)); //
                while (count > 0) {
                    if (s.charAt(left) == excess) {
                        count--;
                    }
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left++; //

                }
                map.remove(excess);
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
}
