package algorithms.graphtraversal.trees;

import java.util.Stack;

/**
 * Depth first search can be done as pre-order, in-order and post-order traversal.
 * <p>
 * Pre-order: parent node is processed before the left and right node.
 * In-order: parent node is processed in between the left and right node.
 * Post-order: parent node is processed after the left and right node.
 */
public class DepthFirstSearch {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.right = new Node(6);


    DepthFirstSearch dfs = new DepthFirstSearch();
    dfs.iterativePostOrderDFS(root);
  }

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

  /**
   * This iterative post-order dfs uses a single stack. Time complexity is O(n) and
   * Space complexity is O(n) where n is the number of nodes in the tree.
   * @param node
   */
  public void iterativePostOrderDFS(Node node) {
    if (node == null) {
      return;
    }

    Stack<Node> s1 = new Stack<>();
    Stack<Node> s2 = new Stack<>();
    s1.push(node);

    while(!s1.isEmpty()) {
      Node curr = s1.pop();
      s2.push(curr);
      if (curr.left != null) {
        s1.push(curr.left);
      }
      if (curr.right != null) {
        s1.push(curr.right);
      }
    }

    while(!s2.isEmpty()) {
      Node curr = s2.pop();
      //process node;
      System.out.println(curr.value);
    }
  }

  /**
   * This iterative pre-order dfs uses a single stack. Time complexity is O(n) and
   * space complexity is O(n) where n is the number of nodes in the tree.
   * @param node
   */
  public void iterativePreOrderDFS(Node node) {
    Stack<Node> stack = new Stack<>();
    stack.push(node);

    while(!stack.isEmpty()) {
      Node curr = stack.pop();

      //process node
      System.out.println(curr.value);
      if (curr.right != null) {
        stack.push(curr.right);
      }
      if (curr.left != null) {
        stack.push(curr.left);
      }
    }
  }

  /**
   * This iterative in-order dfs uses two stacks. Time complexity is O(n) and
   * space complexity is O(n).
   * @param node
   */
  public void iterativeInOrderDFS(Node node) {
    Stack<Node> stack = new Stack<>();
    Node curr = node;

    while (curr != null || !stack.isEmpty()) {

      if (curr != null) {
        stack.push(curr);
        curr = curr.left;
      } else {
        curr = stack.pop();
        //process node
        System.out.println(curr.value);
        curr = curr.right;
      }
    }
  }

  /**
   * This iterative dfs uses a single stack. Time complexity is O(n) and
   * unlike with previous approach average space complexity is O(h) and worst case is O(n)
   * where h is the height of the tree and n is the number nodes in the tree.
   * @param node
   */
  public void iterativePostOrderDFS2(Node node) {
    Stack<Node> stack = new Stack<>();
    Node curr = node;

    while(true) {
      if(curr != null) {
        stack.push(curr);
        curr = curr.left;
      } else {
        if (!stack.isEmpty()) {
          break;
        }
        curr = stack.peek().right;
        if (curr == null) {
          Node last = null;
          if (!stack.isEmpty() && stack.peek().right == last) {
            last = stack.pop();
            //process node
            System.out.println(last.value);
          }
        }
      }
    }
  }

  private static class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
}
