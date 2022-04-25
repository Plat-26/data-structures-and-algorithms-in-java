package algorithms.sortingandsearching;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class FindKthLargestElementInArray {

  /**
   * Time: Avg Case: O(n), Worst case: O(n^2) - with bad pivot
   * Space: O(1)
   */
  public int findKthLargest(int[] nums, int k) { //[1, 2, 3, 4, 5, 6] k = 1
    return findKthLargest(nums, 0, nums.length - 1, k);
  }

  /**
   * We use the partitioning subroutine from Quicksort
   * to iteratively get items to their "final resting place" in the final sorted array.
   * Eventually one of these will be the k'th largest element's position.
   * We then have found the answer.
   */
  private int findKthLargest(int[] nums, int left, int right, int k) {

    while(left <= right) {
      int pivotIndex = partition(nums, left, right);

      int n = nums.length;
      /**
       * n - k is the final index of the Kth largest element in the array
       */
      if(pivotIndex == n - k) {
        return nums[pivotIndex];

      } else if(pivotIndex < n - k) {
        left = pivotIndex + 1;

      } else {
        right = pivotIndex - 1;
      }
    }
    return -1;
  }

  private int partition(int[] nums, int left, int right) {
    int pivot = nums[right];

    int i = left - 1;
    for(int j = left; j < right; j++) {
      if(nums[j] < pivot) {
        i++;
        swap(nums, i, j);
      }
    }
    swap(nums, i + 1, right);
    return i + 1;
  }

  private void swap(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
  }
}
