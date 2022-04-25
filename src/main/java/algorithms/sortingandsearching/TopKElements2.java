package algorithms.sortingandsearching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKElements2 {

  /**
   * Time: O(n) n = length of nums
   * Space: O(n)
   */
  public int[] topKFrequent(int[] nums, int k) {

    //get frequency of values in nums
    Map<Integer, Integer> freq = new HashMap<>();
    for(int i : nums) {
      freq.put(i, freq.getOrDefault(i, 0) + 1);
    }
    //freq: 1 - 3, 2 - 2, 3, 1

    //extract unique elements from values
    int i = 0;
    int[] elements = new int[freq.size()];
    for(int key : freq.keySet()) {
      elements[i] = key;
      i++;
    }
    //elemets: 1, 2, 3

    //do a quick select to find top k from unique values
    return findTopKElements(freq, elements, k);
  }

  private int[] findTopKElements(Map<Integer, Integer> freq, int[] elements, int k) {

    int left = 0; // 1
    int right = elements.length - 1;
    int n = elements.length;

    while(left < right) {
      //partition and get pivot index
      int pivotIndex = getPivotIndex(freq, elements, left, right);

      if(pivotIndex == n - k) {
        break;
      } else if(pivotIndex < n - k) {
        left = pivotIndex + 1;
      } else {
        right = pivotIndex - 1;
      }
    }
    //top k elements are on the right of the kth index
    return Arrays.copyOfRange(elements, n - k, n);
  }
  //freq: 1-3, 2-2, 3-1 ; elements: 1, 2, 1; left 1; right 2
  private int getPivotIndex(Map<Integer, Integer> freq, int[] elements, int left, int right) {

    int pivot = freq.get(elements[right]); //3

    //sort/partition according to frequency of the unique elemnts
    int i = left - 1; //0
    for(int j = left; j < elements.length; j++) {
      if(freq.get(elements[j]) < pivot) {
        i++;
        swap(elements, i, j);
      }
    }
    swap(elements, i + 1, right);
    return i + 1;
  }

  private void swap(int[] elements, int first, int second) {
    int temp = elements[first];
    elements[first] = elements[second];
    elements[second] = temp;
  }
}
