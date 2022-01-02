package algorithms;

/**
 * Depth first search can be done as pre-order, in-order and post-order traversal.
 * <p>
 * Pre-order: parent node is processed before the left and right node.
 * In-order: parent node is processed in between the left and right node.
 * Post-order: parent node is processed after the left and right node.
 */
public class DepthFirstSearch {

  public void dfsPostOrder(Node node) {
    if (node == null) {
      return;
    }
    dfsPostOrder(node.left);
    dfsPostOrder(node.right);
    System.out.println(node.value); //process node
  }

  public void dfsPreOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.println(node.value); //process node
    dfsPreOrder(node.left);
    dfsPreOrder(node.right);
  }

  public void dfsInOrder(Node node) {
    if (node == null) {
      return;
    }
    dfsInOrder(node.left);
    System.out.println(node.value); //process node
    dfsInOrder(node.right);
  }

  private class Node {
    int value;
    Node left;
    Node right;
  }
}
