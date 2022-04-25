package algorithms.graphtraversal.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {

  /**
   * Time: O(n),
   * Space: O(n) where n = number of nodes in tree
   */
  public List<List<Integer>> levelOrder(Node root) {
    if(root == null) {
      return new ArrayList<>();
    }

    List<List<Integer>> ordered = new ArrayList<>();

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> order = new ArrayList<>(levelSize);
      for(int i = 0; i < levelSize; i++) {
        Node curr = queue.poll();
        order.add((int) curr.val);

        if(curr.left != null) {
          queue.add(curr.left);
        }
        if(curr.right != null) {
          queue.add(curr.right);
        }
      }
      ordered.add(order);
    }
    return ordered;
  }
}



