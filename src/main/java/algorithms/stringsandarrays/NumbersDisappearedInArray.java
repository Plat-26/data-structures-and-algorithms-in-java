package algorithms.stringsandarrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 */
public class NumbersDisappearedInArray {

  /**
   * Time: O(n)
   * Space: O(1)
   */
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();

    for(int num : nums) {
      int index = Math.abs(num) - 1;

      if(nums[index] > 0) {
        nums[index] *= -1;
      }
    }

    for(int i = 1; i <= nums.length; i++) {
      if(nums[i - 1] > 0) {
        result.add(i);
      }
    }
    return result;
  }
}
