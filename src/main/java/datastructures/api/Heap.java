package datastructures.api;

/**
 * An heap is a complete binary tree.
 * The parent node has the highest priority in the heap.
 * Min Heap: the value at the root has a lower value than its left and right child
 * Max Heap: parent has a greater value than its left and right child.
 */
public interface Heap {

  int poll();

  int peek();

  /**
   * Adds a value to the heap. The heap is then rearranged(heapifyUp) to satisfy Min/Max Heap condition.
   * Time Complexity: O(h) where h is the height of tree.
   * Since Heap has h == log n where n is the number of nodes in the heap,
   * Time complexity = O(log n).
   * @param value
   */
  void insert(int value);


  /**
   * Removes the element at the root of the heap.
   * The last node in the heap is used to replace the root node.
   * The heap is then rearranged(heapifyDown) to satisfy Min/Max Heap condition.
   * Time Complexity: O(h) where h is the height of tree.
   * Since Heap has h == log n where n is the number of nodes in the heap,
   * Time complexity = O(log n).
   * @return
   */
  int delete();

  /**
   * Retrieves the min(or max for Max-Heap) value from the Min-Heap.
   * Time: O(1).
   * @return
   */
  int getMin();
}
