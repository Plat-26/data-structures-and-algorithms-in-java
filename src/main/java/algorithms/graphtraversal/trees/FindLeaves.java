package algorithms.graphtraversal.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 */
public class FindLeaves {

  private List<List<Integer>> leaves = new ArrayList<>();

  public List<List<Integer>> findLeaves(TreeNode root) {
    findLeavesHelper(root);
    return leaves;
  }

  /**
   * Time: O(n)
   * Space: O(n)
   * where n is the number of nodes in the tree.
   * @param root
   * @return
   */
  private int findLeavesHelper(TreeNode root) {
    if(root == null) {
      return -1;
    }

    int leftIndex = findLeavesHelper(root.left);
    int rightIndex = findLeavesHelper(root.right);
    int curr = Math.max(leftIndex, rightIndex) + 1;

    if(leaves.size() <= curr) {
      leaves.add(new ArrayList());
    }

    leaves.get(curr).add(root.val);
    return curr;
  }
}
