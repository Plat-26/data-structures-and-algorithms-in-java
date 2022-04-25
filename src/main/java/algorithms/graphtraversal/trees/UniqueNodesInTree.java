package algorithms.graphtraversal.trees;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the maximum number of distinct nodes in a Binary Tree Path
 */
public class UniqueNodesInTree {

  public int maxUnique(Node<Integer> root) {
    Set<Integer> set = new HashSet<>();
    return traverse(root, set);
  }

  private int traverse(Node<Integer> root, Set<Integer> unique) {
    if(root == null || unique.contains(root.val)) {
      return unique.size();
    }

    unique.add(root.val);
    int maxLeft = traverse(root.left, unique);
    int maxRight = traverse(root.right, unique);
    unique.remove(root.val);
    return Math.max(maxLeft, maxRight);
  }
}
