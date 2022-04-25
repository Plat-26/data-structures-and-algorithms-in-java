package algorithms.stringsandarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 1; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int target = -nums[i];
      int low = i + 1;
      int high = nums.length - 1;
      while (low < high) {
        int val = nums[low] + nums[high];
        if (val < target) {
          low++;
        } else if (val > target) {
          high--;
        } else {
          result.add(Arrays.asList(nums[i], nums[low], nums[high]));
          low++; high--;
          while (low < high && nums[low] == nums[low - 1]) {
            low++;
          }
        }
      }
    }
    return result;
  }
}
