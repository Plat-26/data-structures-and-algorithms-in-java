package algorithms.dynamicprogramming.tabulation;

import java.util.ArrayList;
import java.util.List;

public class BestSumTabulation {

    public static void main(String[] args) {
        BestSumTabulation bestSumTabulation = new BestSumTabulation();
        List<Integer> bestSum = bestSumTabulation.bestSum(8, new int[]{2, 3, 5});
        System.out.println(bestSum.toString());
    }

    public List<Integer> bestSum(int target, int[] numbers) {
        List[] arry = new List[target + 1];
        arry[0] = new ArrayList<Integer>();

        for (int i = 0; i < arry.length; i++) {
            if(arry[i] != null) {
                for (int num : numbers) {
                    if (num + i < arry.length) {
                        List<Integer> newList = new ArrayList<Integer>(arry[i]);
                        newList.add(num);
                        List currentList = arry[num + i];
                        if (currentList == null || currentList.size() > newList.size()) {
                            arry[num + i] = newList;
                        }
                    }
                }
            }
        }
        return arry[target];
    }
}
