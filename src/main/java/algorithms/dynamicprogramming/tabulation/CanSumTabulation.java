package algorithms.dynamicprogramming.tabulation;

/**
 * AS PART OF DYNAMIC PROGRAMMING
 * Write a function `canSum(int target, int[] numbers)` that takes in a target value and an array of numbers
 * as arguments. The function should return a boolean indicating weather or not it is possible to generate the target
 * sum using numbers from the array.
 *
 * You may use an element of the array as many times as possible.
 * You may assume that all input numbers are non-negative.
 */
public class CanSumTabulation {

    public static void main(String[] args) {
        CanSumTabulation canSumTab = new CanSumTabulation();
        boolean canSum = canSumTab.canSum(7, new int[]{3, 4, 5});
        System.out.println(canSum);
    }

    /**
     * Time: O(mn)
     * Space: O(m)
     * @param target, m
     * @param numbers, n
     * @return
     */
    public boolean canSum(int target, int[] numbers) {
        boolean[] array = new boolean[target + 1];
        array[0] = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                for (int num : numbers) {
                    if (i + num < array.length) {
                        array[i + num] = true;
                    }
                }
            }
        }
        return array[target];
    }
}
