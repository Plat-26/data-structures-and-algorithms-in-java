package algorithms.graphtraversal.trees;

import java.util.Stack;

/**
 * Find the maximum depth of a tree.
 */
public class TreeMaxDepth {

  public int treeMaxDepth(Node<Integer> root) {
    int maxDepth = 0;

    Stack<Node<Integer>> nodeStack = new Stack<>();
    Stack<Integer> distanceStack = new Stack<>();

    nodeStack.push(root);
    distanceStack.push(1);

    while (!nodeStack.isEmpty()) {
      Node<Integer> currNode = nodeStack.pop();
      int dist = distanceStack.pop();
      maxDepth = Math.max(maxDepth, dist);

      if (currNode.left != null) {
        nodeStack.push(currNode.left);
        distanceStack.push(dist + 1);
      }

      if (currNode.right != null) {
        nodeStack.push(currNode.right);
        distanceStack.push(dist + 1);
      }
    }
    return maxDepth;
  }

  public int treeMaxDepthR(Node<Integer> root) {
    if (root == null) {
      return 0;
    }
    return Math.max(treeMaxDepthR(root.left) + 1, treeMaxDepthR(root.right) + 1);
  }
}
