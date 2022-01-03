package datastructures.api;

public interface Queue<T> {

  /**
   * Appends a new element to the end of the queue in constant O(1) time and O(1) space
   * @param element
   */
  void add(T element);

  /**
   * Removes the element at the front of the queue in O(1) time and O(1) space.
   * @return
   */
  T poll();

  /**
   * Retrieves (does not delete) the element at front of the queue in O(1) time and O(1) space.
   * @return
   */
  T peek();

  /**
   * Performs the same function as add.
   * Appends a new element to the end of the queue in constant O(1) time and O(1) space.
   * @param element
   */
  void enqueue(T element);

  /**
   * Performs the same function as poll.
   * Removes the element at the front of the queue in O(1) time.
   * @return
   */
  T dequeue();
}
