package algorithms.graphtraversal.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a function, treeSum, that takes in the root of a binary tree that contains number values.
 * The function should return the total sum of all values in the tree.
 */
public class TreeSum {

  public static void main(String[] args) {
    Node<Integer> a = new Node<>(3);
    Node<Integer> b = new Node<>(11);
    Node<Integer> c = new Node<>(4);
    Node<Integer> d = new Node<>(4);
    Node<Integer> e = new Node<>(-2);
    Node<Integer> f = new Node<>(1);

    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.right = f;

    TreeSum sum = new TreeSum();
    int sum2 = sum.treeSum(a);
    System.out.println(sum2);
    int sum1 = sum.treeSumR(a);
    System.out.println(sum1);
  }

  public int treeSum(Node<Integer> root) {
    int sum = 0;
    Queue<Node<Integer>> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {
      Node<Integer> current = queue.poll();
      sum += current.val;

      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }
    return sum;
  }

  public int treeSumR(Node<Integer> node) {
    if (node == null) {
      return 0;
    }
    return node.val + treeSumR(node.left) + treeSumR(node.right);
  }
}
