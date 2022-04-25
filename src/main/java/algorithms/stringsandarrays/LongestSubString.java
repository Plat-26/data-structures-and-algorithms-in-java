package algorithms.stringsandarrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubString {

  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 1) {
      return 1;
    }

    Set<Character> set = new HashSet<>();
    int length = 0;
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      if (!set.contains(c)) {
        int size = right - left + 1;
        length = Math.max(length, size );
        set.add(c);
      } else {
        while(s.charAt(left) != c) {
          set.remove(s.charAt(left));
          left++;
        }
        left++;
      }
    }
    return length;
  }
}
