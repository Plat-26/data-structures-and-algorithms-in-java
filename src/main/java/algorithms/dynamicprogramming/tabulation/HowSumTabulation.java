package algorithms.dynamicprogramming.tabulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function howSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments
 *
 * The function should return an array containing any combination of elements that add up to exactly the targetSum.
 * If there is no combination that adds up to the targetSum, then return null.
 *
 * If there are multiple combinations possible, you may return any single one.
 */
public class HowSumTabulation {

    public static void main(String[] args) {
        HowSumTabulation tab = new HowSumTabulation();
        List<Integer> howSum = tab.howSum(7, new int[]{3, 4, 5});
        System.out.println(howSum.toString());
    }

    public List<Integer> howSum(int target, int[] numbers) {
        List[] arry = new List[target + 1];
        arry[0] = new ArrayList<>();

        for (int i = 0; i < arry.length; i++) {
            if (arry[i] != null) {
                for (int num : numbers) {
                    if (i + num <= target) {
                        List<Integer> curr = arry[i];
                        List<Integer> newArray = new ArrayList<>(curr);
                        newArray.add(num);

                        arry[i + num] = newArray;
                    }
                }
            }
        }
        return arry[target];
    }


}
