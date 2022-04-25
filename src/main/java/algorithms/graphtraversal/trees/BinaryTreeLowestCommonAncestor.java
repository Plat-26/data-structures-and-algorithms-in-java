package algorithms.graphtraversal.trees;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */
public class BinaryTreeLowestCommonAncestor {




  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }

    if(root.val == p.val || root.val == q.val) {
      return root;
    }

    TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
    TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);
    if(leftSearch == null) return rightSearch;
    if(rightSearch == null) return leftSearch;

    return root;
  }
}
