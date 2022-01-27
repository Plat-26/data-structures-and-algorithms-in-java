package algorithms.slidingwindow;

import java.util.*;

/**
 * Given an integer array, find a subarray having a given sum in it.
 */
public class SubarrayWithTarget {

    public static void main(String[] args) {
        SubarrayWithTarget subarray = new SubarrayWithTarget();
        Integer[] target = subarray.findSubarrayWithTarget(new int[]{1, 2, 3, 4, 5, 6}, 11);
        System.out.println(Arrays.toString(target));

        Integer[] target2 = subarray.findSubarrayWithTarget(new int[]{0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10}, 15);
        System.out.println(Arrays.toString(target2));
    }
    //{0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10} target = 15 - {1, -4, 7, 6, 1, 4} or {4, 1, 10}


    /**
     * Time: O(n)
     * Space: O(n) since result set can expand up to the length of the initial array
     * This implementation only applies to an array of positive integers.
     * @param array
     * @param target
     * @return
     */
    public Integer[] findSubarrayWithTarget(int[] array, int target) {
        List<Integer> result = new ArrayList<>();
        int windowSum = 0; //11

        //initialize sliding window
        int left = 0;
        for (int right = 0; right < array.length; right++) {

            //if less than keep adding
            if (windowSum < target) {
                windowSum += array[right];
            }

            //if greater than move left pointer forward
            if (windowSum > target) {
                while (windowSum > target) {
                    windowSum -= array[left];
                    left++;
                }
            }

            //if equal to, keep window as result
            if (windowSum == target) {
                for(int i = left; i < right + 1; i++) {
                    result.add(array[i]);
                }
                break;
            }
        }
        Integer[] nums = new Integer[result.size()];
        result.toArray(nums);
        return nums;
    }

    /**
     * Solve with Hashing
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @param target
     * @return
     */
    public boolean findSubArray(int[] nums, int target) {

        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        int currentSum = 0;
        for (int i : nums) {
            currentSum += i;
            if(seen.contains(currentSum - target)) {
                return true;
            }
            seen.add(currentSum);
        }
        return false;
    }
}
