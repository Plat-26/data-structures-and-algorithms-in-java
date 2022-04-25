package algorithms.sortingandsearching;

import java.util.Arrays;

/**
 * Arrange the elements of an array in sorted order using heap sort
 */
public class HeapSort {
  private int[] arry = null;

  public static void main(String[] args) {
    int[] arry = new int[]{10, 6, 7, 5, 17, 12, 15};
    HeapSort heap = new HeapSort();
    heap.heapsort(arry);
    System.out.println(Arrays.toString(arry));
  }

  /**
   * Time: O(n log n)
   * Space: O(1)
   * @param arry Array to be sorted
   */
  public void heapsort(int[] arry) {//{17, 10, 15, 5, 6, 7, 12}
    this.arry = arry;
    //build max heap
    buildMaxHeap();
    //position elements by swap
    positionElements();
  }

  private void positionElements() {
    int start = 0;
    int end = arry.length - 1;
    while(end > 0) {
      swap(start, end);
      heapifyDown(start, end);
      end--;
    }
  }

  private void buildMaxHeap() {
    int start = arry.length / 2; //start from half of the array since the upper part will always be swapd with lower to get proper position
    for(int i = start; i >= 0; i--) {
      heapifyDown(i, arry.length);
    }
  }

  private void heapifyDown(int index, int range) {
    while(getLeftChildIndex(index) < range) { //has left child within range
      int largestChildIndex = getLeftChildIndex(index);
      if(getRightChildIndex(index) < range) { //has right child within range
        if(arry[getRightChildIndex(index)] > arry[largestChildIndex]) {
          largestChildIndex = getRightChildIndex(index);
        }
      }

      if(arry[index] > arry[largestChildIndex]) {
        break;
      } else {
        swap(index, largestChildIndex);
      }
    }
  }

  private void heapifyDown(int index) {
    while(hasLeftChild(index)) {
      int largestChildIndex = getLeftChildIndex(index);
      if(hasRightChild(index)) {
        if(arry[getRightChildIndex(index)] > arry[largestChildIndex]) {
          largestChildIndex = getRightChildIndex(index);
        }
      }

      if(arry[index] > arry[largestChildIndex]) {
        break;
      } else {
        swap(index, largestChildIndex);
      }
    }
  }

  private void swap(int first, int second) {
    int temp = arry[first];
    arry[first] = arry[second];
    arry[second] = temp;
  }
  private boolean hasRightChild(int index) {
    return (index * 2) + 2 < arry.length;
  }

  private boolean hasLeftChild(int index) {
    return (index * 2) + 1 < arry.length;
  }

  private int getRightChildIndex(int index) {
    return (index * 2) + 2;
  }

  private int getLeftChildIndex(int index) {
    return (index * 2) + 1;
  }
}
