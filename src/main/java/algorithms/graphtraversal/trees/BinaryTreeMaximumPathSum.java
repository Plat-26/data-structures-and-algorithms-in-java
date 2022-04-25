package algorithms.graphtraversal.trees;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence
 * has an edge connecting them. A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class BinaryTreeMaximumPathSum {
  /**
   *   1
   *  / \
   * 2   3
   * \
   * 4
  */
  private int max = Integer.MIN_VALUE;

  public int maxPathSum(Node<Integer> root) {
    findMaxPathSum(root);
    return max;
  }

  private int findMaxPathSum(Node<Integer> root) {
    if(root == null) {
      return 0;
    }

    int maxLeft = Math.max(maxPathSum(root.left), 0);
    int maxRight = Math.max(maxPathSum(root.right), 0);

    max = Math.max(max, maxLeft + maxRight + root.val);
    return Math.max(maxLeft, maxRight) + root.val;
  }
}
