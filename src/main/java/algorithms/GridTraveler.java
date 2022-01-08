package algorithms;

import java.util.HashMap;

/**
 * AS PART OF DYNAMIC PROGRAMMING
 * Say that you are a grid traveler on a 2D grid. You begin in the top-left corner and your goal is
 * to travel to the bottom-right corner. You may only move down or right.
 * In how many ways can you travel to the goal (bottom right) on a grid with dimensions m * n?
 */
public class GridTraveler {

  public static void main(String[] args) {
    GridTraveler traveler = new GridTraveler();

    System.out.println(traveler.gridTraveler(18, 18, new HashMap<>()));
  }

  /**
   * Time complexity: O(2 ^ m + n);
   * Space complexity: O(m + n)
   * @param m
   * @param n
   * @return
   */
  public int gridTraveler(int m, int n) {
    if (m == 1 && n == 1) {
      return 1;
    }
    if (m == 0 || n == 0) {
      return 0;
    }
    return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
  }

  /**
   * Time complexity: O(m + n)
   * Space complexity: O(m + n)
   * @param m
   * @param n
   * @param memo
   * @return
   */
  public long gridTraveler(int m, int n, HashMap<String, Long> memo) {
    String key = m + "," + n;
    if (memo.containsKey(key)) {
      return memo.get(key);
    }
    if (m == 1 && n == 1) {
      return 1;
    }
    if (m == 0 || n == 0) {
      return 0;
    }
    long value = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
    memo.put(key, value);
    return memo.get(key);
  }
}
