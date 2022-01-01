package datastructures;

import java.util.Arrays;

/**
 * The min heap has its smallest value at the root node.
 */
public class MinHeap {
  private int capacity;
  private int size;
  int[] elements;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.elements = new int[capacity];
  }

  /**
   * Returns (without removing) the smallest value in the heap
   * @return
   */
  public int peek() {
    if (size == 0) {
      throw new IllegalStateException("Heap is empty cannot peek");
    }
    return elements[0];
  }

  /**
   * Returns and removes the smallest value in the heap
   * @return
   */
  public int poll() {
    if (size == 0) {
      throw new IllegalStateException("Heap is empty cannot poll");
    }

    int item = elements[0];
    elements[0] = elements[size - 1];
    size--;
    heapifyDown();
    return item;
  }

  /**
   * Adds a new element to the heap
   * @param element
   */
  public void add(int element) {
    ensureCapacity();
    elements[size] = element;
    size++;
    heapifyUp();
  }

  private void heapifyDown() {
    int index = 0;
    while (hasLeftNode(index)) {
      int smallestChildIndex = getLeftNodeIndex(index);
      if (hasRightNode(index) && rightNode(index) < leftNode(index)) {
        smallestChildIndex = getRightNodeIndex(index);
      }

      if (elements[index] < elements[smallestChildIndex]) {
        break;
      } else {
        swap(index, smallestChildIndex);
        index = smallestChildIndex;
      }
    }
  }

  private void heapifyUp() {
    int index = size - 1;

    while(hasParentNode(index) && parentNode(index) > elements[index]) {
      swap(getParentNodeIndex(index), index);
      index = getParentNodeIndex(index);
    }
  }

  private void swap(int index1, int index2) {
    int temp = elements[index1];
    elements[index1] = elements[index2];
    elements[index2] = temp;
  }

  private void ensureCapacity() {
    if(capacity == size) {
      elements = Arrays.copyOf(elements, capacity * 2);
    }
  }

  private int parentNode(int index) {
    return elements[getParentNodeIndex(index)];
  }

  private int rightNode(int index) {
    return elements[getRightNodeIndex(index)];
  }

  private int leftNode(int index) {
    return elements[getLeftNodeIndex(index)];
  }

  private int getParentNodeIndex(int index) {
    return (index - 1 ) / 2;
  }

  private int getLeftNodeIndex(int index) {
    return (index * 2) + 1;
  }

  private int getRightNodeIndex(int index) {
    return (index * 2) + 2;
  }

  private boolean hasParentNode(int index) {
    return getParentNodeIndex(index) >= 0;
  }

  private boolean hasLeftNode(int index) {
    return getLeftNodeIndex(index) < size;
  }

  private boolean hasRightNode(int index) {
    return getRightNodeIndex(index) < size;
  }
}
