package algorithms.stringsandarrays;

import java.util.Stack;

/**
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return t[
 * he final string after all such duplicate removals have been made.
 * It can be proven that the answer is unique.
 */
public class RemoveAdjacentDuplicatesInString {

  /**
   * Time: O(n)
   * Space: O(n)
   * @param s
   * @return
   */
  public String removeDuplicates(String s) {
    StringBuilder sb = new StringBuilder();
    int sbLength = 0;
    for(char c : s.toCharArray()) {
      if(sbLength > 0 && c == sb.charAt(sbLength - 1)) {
        sb.deleteCharAt(sbLength - 1);
        sbLength--;
      }
      else {
        sb.append(c);
        sbLength++;
      }
    }
    return sb.toString();
  }
}
