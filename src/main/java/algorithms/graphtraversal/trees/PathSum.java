package algorithms.graphtraversal.trees;

import java.util.Stack;
import javafx.util.Pair;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding
 * up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
public class PathSum {
  public boolean hasPathSum(Node<Integer> root, int targetSum) {
    if(root == null) {
      return false;
    }
    //use dfs
    //create stack and add current node to stack
    Stack<Pair<Node, Integer>> stack = new Stack<>();
    stack.push(new Pair<Node, Integer>(root, (targetSum - root.val)));

    while(!stack.isEmpty()) {
      Pair<Node, Integer> curr = stack.pop();

      Node node = curr.getKey();
      int currSum = (int) curr.getValue();
      if(node.left == null && node.right == null && currSum == 0) {
        return true;
      }

      if(node.left != null) {
        int temp = currSum - (int) node.left.val;
        stack.push(new Pair<Node, Integer>(node.left, temp));
      }
      if(node.right != null) {
        int temp = currSum - (int) node.right.val;
        stack.push(new Pair<>(node.right, temp));
      }
      //retrurn true if sum is zero
      //add left and right node
      //return false after loop
    }
    return false;
  }//Time: O(n) space: Log N
}
