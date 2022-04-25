package algorithms.sortingandsearching;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function,
 * nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the
 * resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInRotatedSortedArray {

  /**
   * Time: O(log n), Space: O(1)
   * @param nums
   * @param target
   * @return
   */
  public int search(int[] nums, int target) { //[4, 5, 6, 7, 0, 1, 2]
    //0, 1, 2, 4, 5, 6, 7

    int start = 0;
    int end = nums.length - 1;

    while(start <= end) {
      int mid = (start + end) / 2;

      if(nums[mid] == target) {
        return mid;

      } else if(nums[mid] >= nums[start]) {
        if(target >= nums[start] && target < nums[mid]) end = mid - 1;
        else start = mid + 1;
      } else {
        if(target <= nums[end] && target > nums[mid]) start = mid + 1;
        else end = mid - 1;
      }
    }
    return -1;
  }
}
