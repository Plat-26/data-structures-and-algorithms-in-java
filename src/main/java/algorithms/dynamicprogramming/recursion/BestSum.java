package algorithms.dynamicprogramming.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {

    public static void main(String[] args) {
        BestSum bestSum = new BestSum();
        int[] numbers = new int[] {3, 4, 2, 7, 5};
        System.out.println(bestSum.findBestSum(7, numbers, new HashMap<>()).toString());

        int[] numbers2 = new int[] {1, 2, 5, 25};
        System.out.println(bestSum.findBestSum(100, numbers2, new HashMap<>()).toString());

    }

    /**
     * m = target sum, n = length of array
     * Time: O(n^m * m)
     * Space: O(m)
     * @param targetSum
     * @param numbers
     * @return
     */
     public List<Integer> findBestSum(int targetSum, int[] numbers) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        List<Integer> shortestCombination = null;
        for (int num: numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderCombination = findBestSum(remainder, numbers);
            if (remainderCombination != null) {
                remainderCombination.add((num));
                if(shortestCombination == null || remainderCombination.size() < shortestCombination.size()) {
                    shortestCombination = remainderCombination;
                }
            }
        }
        return shortestCombination;
     }

    /**
     * Time O(m * n * m)
     * Space: O(m^2)
     * @param targetSum
     * @param numbers
     * @param memo
     * @return
     */
     public List<Integer> findBestSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
         if(memo.containsKey(targetSum)) {
            return memo.get(targetSum);
         }
         if (targetSum == 0) {
             return new ArrayList<>();
         }
         if (targetSum < 0) {
             return null;
         }
         List<Integer> shortestCombination = null;

         for (int num : numbers) {
             int remainder = targetSum - num;
             List<Integer> combination = findBestSum(remainder, numbers, memo);
             if (combination != null) {
                 combination.add(num);
                 if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                     shortestCombination = combination;
                 }
             }
         }
         memo.put(targetSum, shortestCombination);
         return shortestCombination;
     }
}
