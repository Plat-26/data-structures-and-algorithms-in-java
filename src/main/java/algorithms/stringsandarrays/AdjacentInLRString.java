package algorithms.stringsandarrays;

/**
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
 * a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence
 * of "RX" with "XR". Given the starting string start and the ending string end,
 * return True if and only if there exists a sequence of moves to transform one string to the other.
 *
 * Example 1:
 *
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: true
 * Explanation: We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * Example 2:
 *
 * Input: start = "X", end = "L"
 * Output: false
 */
public class AdjacentInLRString {

  /**
   * Time: O(n)
   * Space: O(n)
   */
  public boolean canTransform(String start, String end) {
    if(start.length() <= 1 || end.length() <= 1) {
      return false;
    }

    String s1 = start.replaceAll("X", "");
    String s2 = end.replaceAll("X", "");
    if(!s1.equals(s2)) {
      return false;
    }

    int i = 0;
    int j = 0;
    int len = end.length();
    while(i < len && j < len) {
      if(start.charAt(i) == 'X') {
        i++;
      } else if(end.charAt(j) == 'X') {
        j++;
      } else  {
        if(start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R' && i > j) {
          return false;
        }
        i++; j++;
      }
    }
    return true;
  }
}
