package datastructures.api;

public interface Tree<T> {

  /**
   * Binary Tree - Worst case Time: O(n) where n is the number of nodes.
   * Binary Search Tree - Average case Time: O(h) where h is the height of the tree.
   * @param element
   * @return
   */
  T search(T element);

  /**
   * Worst case Time: O(n)
   * Binary Search Tree - Average case Time: O(h) where h is the height of the tree.
   * @param element
   * @return
   */
  void insert(T element);

  /**
   * Worst case Time: O(n)
   * Binary Search Tree - Average case Time: O(h) where h is the height of the tree.
   * @param element
   * @return
   */
  void delete(T element);
}
