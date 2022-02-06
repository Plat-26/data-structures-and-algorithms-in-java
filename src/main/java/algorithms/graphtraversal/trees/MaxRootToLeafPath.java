package algorithms.graphtraversal.trees;

/**
 * Write a function, maxPathSum, that takes in the root of a binary tree that contains number
 * values. The function should return the maximum sum of any root to leaf path within the tree.
 *
 * You may assume that the input tree is non-empty.
 */
public class MaxRootToLeafPath {

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

    MaxRootToLeafPath root = new MaxRootToLeafPath();
    int sum = root.maxPathSum(a);
    System.out.println(sum);
  }

  //       3
//    /    \
//   11     4
//  / \      \
// 4   -2     1

  public int maxPathSum(Node<Integer> root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    if (root.left == null && root.right == null) {
      return root.val;
    }

    int maxChildSum = Math.max(maxPathSum(root.left), maxPathSum(root.right));
    return root.val + maxChildSum;
  }
}
