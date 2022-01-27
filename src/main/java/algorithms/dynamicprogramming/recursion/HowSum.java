package algorithms.dynamicprogramming.recursion;

import java.util.*;

/**
 * Write a function howSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments
 *
 * The function should return an array containing any combination of elements that add up to exactly the targetSum.
 * If there is no combination that adds up to the targetSum, then return null.
 *
 * If there are multiple combinations possible, you may return any single one.
 */
public class HowSum {
    public static void main(String[] args) {
        HowSum how = new HowSum();
        int[] nums = new int[]{3, 5, 2};
        how.howSum(8, nums, new HashMap<>());
        System.out.println(how.howSum(8, nums).toString());
    }

    public List<Integer> howSum(int targetSum, int[] numbers) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        for(int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> result = howSum(remainder, numbers);
            if (result != null) {
                result.add(num);
                return result;
            }
        }
        return null;
    }

    public List<Integer> howSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if(memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        for(int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> result = howSum(remainder, numbers, memo);
            if (result != null) {
                result.add(num);
                memo.put(targetSum, result);
                return result;
            }
        }
        memo.put(targetSum, null);
        return null;
    }
}
