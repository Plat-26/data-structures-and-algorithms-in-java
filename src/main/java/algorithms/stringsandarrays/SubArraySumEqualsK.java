package algorithms.stringsandarrays;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays
 * whose sum equals to k.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
public class SubArraySumEqualsK {

  /**
   * Time: O(n)
   * Space: O(n)
   */
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    int sum = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for(int num : nums) {
      sum += num;
      if(map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
