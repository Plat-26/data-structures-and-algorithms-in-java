package algorithms.dynamicprogramming.recursion;

import java.util.HashMap;

/**
 * AS PART OF DYNAMIC PROGRAMMING
 * Write a function `canSum(int target, int[] numbers)` that takes in a target value and an array of numbers
 * as arguments. The function should return a boolean indicating weather or not it is possible to generate the target
 * sum using numbers from the array.
 *
 * You may use an element of the array as many times as possible.
 * You may assume that all input numbers are non-negative.
 */
public class CanSum {

    public static void main(String[] args) {
        CanSum canSum = new CanSum();
        boolean b = canSum.canSum(300, new int[]{7, 14});
        System.out.println(b);
    }

    /**
     * Time complexity: O(n^m)
     * Space complexity: O(m)
     * @param targetSum
     * @param numbers
     * @return
     */
    public boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSum(remainder, numbers)) {
                return true;
            }
        }
        return false;
    }

    public boolean canSum (int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        if (targetSum ==  0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSum(remainder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

}
