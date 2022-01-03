package datastructures.api;

public interface Stack<T> {

  /**
   * Retrieves the top element on the stack in O(1) time
   * @return
   */
  T peek();

  /**
   * Appends a new element to the top of the stack in O(1) time
   * @param node
   */
  void push(T node);

  /**
   * Removes the top element from the stack in O(1) time
   * @return
   */
  T pop();
}
