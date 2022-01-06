package datastructures;

/**
 * A balanced binary search tree is sorted such that the left child has a value less than the parent
 * while the right child has a value greater than its parent. This is recursively true of all nodes
 * in the tree.
 *
 * The time complexity of insert and remove in a standard BST is O(n) while insert and remove in a
 * balanced binary search tree is O(log n).
 */
public class BinarySearchTree {

  private Node root;

  /**
   * Adds a value to the BST
   *
   * @param value
   */
  public void add(int value) {
    root = addRecursive(root, value);
  }

  /**
   * Helper method to add a value into the binary search tree recursively
   *
   * @param current
   * @param value
   * @return
   */
  private Node addRecursive(Node current, int value) {
    if (current == null) {
      return new Node(value);
    }

    if (value < current.value) {
      current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
      current.right = addRecursive(current.right, value);
    } else {
      return current;
    }
    return current;
  }

  public boolean containsNode(int value) {
    return containsNodeRecursive(this.root, value);
  }

  private boolean containsNodeRecursive(Node current, int value) {
    if (current == null) {
      return false;
    }

    if (current.value == value) {
      return true;
    }

    if (value < current.value) {
      return containsNodeRecursive(current.left, value);
    } else {
      return containsNodeRecursive(current.right, value);
    }
  }

  private static class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
}
