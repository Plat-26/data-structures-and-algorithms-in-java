package algorithms.sortingandsearching;

/**
 * Worst time: O(n^2) when pivot is bad
 * Average and Best Time: O(n log n)
 * Space: O(n) - call stack
 */
public class QuickSort {

  public int[] quicksort(int[] arr) {
    quicksort(arr, 0, arr.length - 1);
    return arr;
  }

  // Helper function to recursively perform quicksort
  // quicksort will be called recursively for the elemnts to the left of pivot
  // And the elements to the right of pivot
  private void quicksort(int[] arry, int left, int right) {
    // Only proceed if left is less than right
    if(left < right) {
      //Find the position of the pivot
      //find pivot index after partition
      int pivot = partition(arry, left, right);

      // Recursively call left and right subarray to the pivot
      //recurse for left and right of pivot
      quicksort(arry, left, pivot - 1);
      quicksort(arry, pivot + 1, right);
    }
  }

  /*
   * The partition function that chooses a pivot, partitions the array around the
   * pivot, places the pivot value where it belongs, and then returns the index of
   * where the pivot finally lies
   */
  private int partition(int[] arry, int left, int right) {
    //choose pivot
    int pivot = arry[right];

    //loop through array and separate less and greater than pivot

    /*
     * i will keep track of the "tail" of the section of items less than the pivot
     * so that at the end we can "sandwich" the pivot between the section less than
     * it and the section greater than it
     */
    int i = left - 1;
    for(int j = left; j < right; j++) {
      if(arry[j] < pivot) {
        i++;
        swap(arry, i, j);
      }
    }
    //put pivot at postion between less and greater than values, usually where i is
    swap(arry, i + 1, right);
    return i + 1; // Return the pivot's final resting place
  }

  // Helper function to swap elements at 2 different array indices
  private void swap(int[] arry, int right, int left) {
    int temp = arry[right];
    arry[right] = arry[left];
    arry[left] = temp;
  }

}
