package algorithms.sortingandsearching;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKElements {

  //Time: O(nlogk) Space: O(n + k)
  public int[] topKFrequent(int[] nums, int k) {
    //determine count of each value in array
    Map<Integer, Integer> freq = getFrequency(nums);

    //use heap to find top k elements
    PriorityQueue<Integer> heap = new PriorityQueue<>(
        k, (n1, n2) -> freq.get(n1) - freq.get(n2)
    );

    for(int i : freq.keySet()) {
      heap.add(i);
      if(heap.size() > k) {
        heap.poll();
      }
    }

    //extract result from heap
    int[] result = new int[k];
    int i = 0;
    while(!heap.isEmpty()) {
      result[i] = heap.poll();
      i++;
    }
    return result;
  }

  private Map<Integer, Integer> getFrequency(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    for(int i : nums) {
      freq.put(i, freq.getOrDefault(i, 0) + 1);
    }
    return freq;
  }
}
