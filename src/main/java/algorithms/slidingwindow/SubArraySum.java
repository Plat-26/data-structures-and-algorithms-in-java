package algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array, find the minimum sum subarray of size k, where k is a positive integer.
 */
public class SubArraySum {

    public static void main(String[] args) {
        SubArraySum arry = new SubArraySum();
        Integer[] minSubArray = arry.findMinSubArray(new int[]{10, 4, 2, 5, 6, 3, 8, 1}, 3);
        System.out.println(Arrays.toString(minSubArray));
        Integer[] minSubArray2 = arry.findMinSubArray(new int[]{1, 2, 3, 4, 1}, 2);
        System.out.println(Arrays.toString(minSubArray2));
    }

    //{10, 4, 2, 5, 6, 3, 8, 1}, k = 3
    private Integer[] findMinSubArray(int[] array, int k) {
        int[] result = new int[2];

        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;

        int windowSize = 0;
        int left = 0;
        for (int right = 0; right < array.length; right++) {
            currentSum += array[right];
            windowSize++;

            if(windowSize == k) {
                if (currentSum < minSum) {
                    minSum = currentSum;
                    result[0] = left;
                    result[1] = right;
                }
                currentSum -= array[left];
                windowSize--;
                left++;
            }
        }
        List<Integer> subArray = new ArrayList<>();
        for (int i = result[0]; i < result[1] + 1; i++) {
            subArray.add(array[i]);
        }
        Integer[] sub = new Integer[subArray.size()];
        subArray.toArray(sub);
        return sub;
    }
}
