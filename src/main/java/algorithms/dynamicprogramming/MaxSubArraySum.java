package algorithms.dynamicprogramming;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubArraySum {

  /**
   * Time: O(n)
   * Space: O(n)
   */
  public int maxSubArray(int[] nums) {
    int[] array = new int[nums.length];
    array[0] = nums[0];

    int max = array[0];

    /**
     * For every index/sub array, the maximum sum is the value at that index or the sum of the
     * maximum from the previous index/sub array.
     */
    for(int i = 1; i < nums.length; i++) {
      array[i] = Math.max(nums[i], nums[i] + array[i - 1]);
      max = Math.max(max, array[i]);
    }
    return max;
  }

  /**
   * Time: O(n)
   * Space: O(1)
   */
  public int maxSubArrayWithConstantSpace(int[] nums) {
    int max = nums[0];

    for(int i = 1; i < nums.length; i++) {
      nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
      max = Math.max(max, nums[i]);
    }
    return max;
  }
}
