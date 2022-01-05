package datastructures.api;

import org.w3c.dom.Node;

public interface Tree<T> {

  /**
   * Binary Tree - Worst case Time: O(n) where n is the number of nodes.
   * Binary Search Tree - Average case Time: O(h) where h is the height of the tree.
   * @param element
   * @return
   */
  T contains(Node root, T element);

  /**
   * Worst case Time: O(n) however this also depends on the structure of the tree
   * Binary Search Tree - Average case Time: O(h) where h is the height of the tree.
   * @param element
   * @return
   */
  void insert(Node root, T element);

  /**
   * Worst case Time: O(n) however this also depends on the structure of the tree
   * Binary Search Tree - Average case Time: O(h) where h is the height of the tree.
   * @param element
   * @return
   */
  void delete(Node root, T element);
}
