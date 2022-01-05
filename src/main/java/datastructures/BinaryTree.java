package datastructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Trees are a hierarchical data structure consisting of a single parent node and its children.
 * <p>
 * Trees provide a moderate insertion and search time O(log n) better then linked lists O(n) but
 * slower than arrays O(1)
 * <p>
 * Binary tree is a type of tree that only has two children: the left and right nodes
 * <p>
 * A binary tree is said to be balanced if its height is O(Log n) where n is the number of nodes.
 * The time complexity for search, insert and delete is also O(log n).
 * <p>
 * In a binary search tree: the left node of every parent node contains values less than the parent
 * node's value the right node of every parent node contains values greater than the parent node's
 * value does not contain duplicate values
 * <p>
 * An AVL tree is a binary search tree in which the difference between the height of a left sub tree
 * and right sub tree of any node cannot be more than 1
 */
public class BinaryTree {

  private Node root;

  public void traversalInOrder(Node node) {
    if (node != null) {
      traversalInOrder(node.left);
      System.out.println(node.value);
      traversalInOrder(node.right);
    }
  }

  public void traversalPreOrder(Node node) {
    if (node != null) {
      System.out.println(node.value);
      traversalPreOrder(node.left);
      traversalPreOrder(node.right);
    }
  }

  public void traversalPostOrder(Node node) {
    if (node != null) {
      traversalPostOrder(node.left);
      traversalPostOrder(node.right);
      System.out.println(node.value);
    }
  }

  public void traversalLevelOrder() {
    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(this.root);

    while (!queue.isEmpty()) {
      Node node = queue.remove();

      System.out.println(node.value);

      if (node.left != null) {
        queue.add(node.left);
      }

      if (node.right != null) {
        queue.add(node.right);
      }
    }
  }

  private class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }
}
