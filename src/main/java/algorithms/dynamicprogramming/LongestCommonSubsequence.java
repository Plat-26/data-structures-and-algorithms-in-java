package algorithms.dynamicprogramming;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters
 * (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 */
public class LongestCommonSubsequence {

  public int longestCommonSubsequence(String text1, String text2) {
    Integer[][] cache = new Integer[text1.length() + 1][text2.length() + 1];
    return lcs(text1, text2, text1.length(), text2.length(), cache);
  }

  private int lcs(String text1, String text2, int m, int n, Integer[][] cache) {
    if(m == 0 || n == 0) {
      return 0;
    }

    if(cache[m - 1][n - 1] != null) {
      return cache[m - 1][n - 1];
    }

    if(text1.charAt(m - 1) == text2.charAt(n - 1)) {
      cache[m - 1][n - 1] = 1 + lcs(text1, text2, m - 1, n - 1, cache);
    } else {
      cache[m - 1][n - 1] = Math.max(lcs(text1, text2, m, n - 1, cache),
          lcs(text1, text2, m - 1, n, cache));
    }

    return cache[m - 1][n - 1];
  }
}
