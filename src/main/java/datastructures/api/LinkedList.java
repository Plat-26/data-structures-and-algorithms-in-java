package datastructures.api;

public interface LinkedList<T> {

  /**
   * Appends a new element to the end of the list in constant O(1) time and O(1) space
   *
   * @param element
   */
  void add(T element);

  /**
   * Removes the element at the head of the in O(1) time and O(1) space
   *
   * @return
   */
  T poll();

  /**
   * Retrieves (does not delete) the first element (head) on the list in O(1) time and O(1) space
   *
   * @return
   */
  T peek();
}
