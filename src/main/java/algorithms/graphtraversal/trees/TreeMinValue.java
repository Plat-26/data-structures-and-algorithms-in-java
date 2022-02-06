package algorithms.graphtraversal.trees;


import java.util.Stack;

/**
 * Write a function, treeMinValue, that takes in the root of a binary tree that contains number
 * values. The function should return the minimum value within the tree.
 *
 * You may assume that the input tree is non-empty.
 */
public class TreeMinValue {

  public static void main(String[] args) {
    Node<Integer> a = new Node<>(3);
    Node<Integer> b = new Node<>(11);
    Node<Integer> c = new Node<>(4);
    Node<Integer> d = new Node<>(-2);
    Node<Integer> e = new Node<>(-5);
    Node<Integer> f = new Node<>(1);

    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.right = f;

    TreeMinValue tmv = new TreeMinValue();
    int min1 = tmv.treeMinValue(a);
    System.out.println(min1);
    int min2 = tmv.minValueR(a, Integer.MAX_VALUE);
    System.out.println(min2);
  }

  public int treeMinValue(Node<Integer> root) {
    int minValue = Integer.MAX_VALUE;

    Stack<Node<Integer>> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node<Integer> current = stack.pop();
      minValue = Math.min(minValue, current.val);

      if (current.left != null) {
        stack.push(current.left);
      }
      if (current.right != null) {
        stack.push(current.right);
      }
    }
    return minValue;
  }

  public int minValueR(Node<Integer> node, int minValue) {
    if (node == null) {
      return Integer.MAX_VALUE;
    }
    minValue = Math.min(minValue, node.val);
    minValue = Math.min(minValue, minValueR(node.right, minValue));
    minValue = Math.min(minValue, minValueR(node.left, minValue));

    return minValue;
  }
}
