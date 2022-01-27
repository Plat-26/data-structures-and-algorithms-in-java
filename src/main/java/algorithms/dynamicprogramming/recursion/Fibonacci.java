package algorithms.dynamicprogramming.recursion;

import java.util.HashMap;

/**
 * AS PART OF DYNAMIC PROGRAMMING
 * Fibonacci sequence: 1, 1, 2, 3, 4...
 * Each value is a sum of the two values before it: n = (n - 1) + (n - 2)
 */
public class Fibonacci {

  public static void main(String[] args) {

    Fibonacci fibonacci = new Fibonacci();
    System.out.println(fibonacci.fib(6));
    System.out.println(fibonacci.fib(50, new HashMap<>()));
  }

  /**
   * Time complexity: O(2^n)
   * Space complexity: O(n)
   * @param n
   * @return
   */
  public int fib(int n) {
    if (n <= 2) {
      return 1;
    }
    return fib(n - 1) + fib(n - 2);
  }

  /**
   * With memoization, evaluated fib(n) are stored in a memo/map and retrieved during processing
   * to avoid re calculation of evaluated data.
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   * @param n
   * @param memo : key - argument to function, value - return value
   * @return long to avoid integer overflow.
   */
  public long fib(int n, HashMap<Integer, Long> memo) {
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    if(n <= 2) {
      return 1;
    }
    memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
    return memo.get(n);
  }
}
