package algorithms.sortingandsearching;

/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class FirstAndLastInSortedArray {
  public int[] searchRange(int[] nums, int target) { //[2, 7, 7, 7, 8, 10]
    int[] position = new int[2];
    position[0] = findBound(nums, 0, nums.length - 1, target, true);
    position[1] = findBound(nums, 0, nums.length - 1, target, false);
    return position;
  }

  private int findBound(int[] nums, int start, int end, int target, boolean isStart) {
    while(start <= end) {
      int mid = (start + end) / 2;

      if(isStart && nums[mid] == target) {

        if(mid == start || nums[mid - 1] != target) {
          return mid;
        }
        end = mid - 1;
      } else if(!isStart && nums[mid] == target) {
        if(mid == end || nums[mid + 1] != target) {
          return mid;
        }
        start = mid + 1;
      } else if(nums[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }
}
