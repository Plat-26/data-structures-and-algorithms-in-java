package algorithms.sortingandsearching;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Write a program which takes as input a very long sequence of numbers
 * and prints the numbers in sorted order.
 * Each number is at most k away from its correctly sorted position.
 * (Such an array is sometimes referred to as being k-sorted).
 */
public class SortKSortedArray {

  public static void main(String[] args) {
    int[] arry = new int[]{3, -1, 2, 6, 4, 5, 8};
    SortKSortedArray sortKSortedArray = new SortKSortedArray();
    sortKSortedArray.completeSort(arry, 3);
    System.out.println(Arrays.toString(arry));
  }
  public void completeSort(int[] arry, int k) {//{3, -1, 2, 6, 4, 5, 8}
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int curr = 0;
    while(queue.size() <= k) {
      queue.add(arry[curr]);
      curr++;
    }
    for(int i = 0; i < arry.length; i++) {
      arry[i] = queue.poll();
      if(queue.size() < k + 1 && curr < arry.length) {
        queue.add(arry[curr]);
        curr++;
      }
    }
  }

}
