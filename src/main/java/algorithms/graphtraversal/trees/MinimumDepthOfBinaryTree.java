package algorithms.graphtraversal.trees;

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the
 * nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthOfBinaryTree {

  public int minDepth(Node root) {
    Queue<Pair<Node, Integer>> queue = new LinkedList<>();

    if(root == null) {
      return 0;
    }
    int minDepth = 0;
    queue.add(new Pair<>(root, 1));
    while(!queue.isEmpty()) {
      Pair<Node, Integer> curr = queue.poll();
      Node node = curr.getKey();
      int dist = curr.getValue();
      minDepth = dist;
      if(node.left == null && node.right == null) {
        break;
      }
      if(node.left != null) {
        queue.add(new Pair<>(node.left, dist + 1));
      }
      if(node.right != null) {
        queue.add(new Pair<>(node.right, dist + 1));
      }
    }
    return minDepth;
  }

  // public int minDepth(TreeNode root) {
  //     if(root == null) {
  //         return 0;
  //     }
  //     if(root.left == null && root.right == null) {
  //         return 1;
  //     }
  //     int minDepth = Integer.MAX_VALUE;
  //     if(root.left != null) {
  //         minDepth = Math.min(minDepth, minDepth(root.left));
  //     }
  //     if(root.right != null) {
  //         minDepth = Math.min(minDepth, minDepth(root.right));
  //     }
  //     return minDepth + 1;
  // }
}
