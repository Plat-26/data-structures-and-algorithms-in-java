package algorithms.graphtraversal.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Write a function, depthFirstValues, that takes in the root of a binary tree.
 * The function should return an array containing all values of the tree in depth-first order.
 */
public class DepthFirstValues {

  public static void main(String[] args) {
    //create example tree
    Node<Character> a = new Node<>('a');
    Node<Character> b = new Node<>('b');
    Node<Character> c = new Node<>('c');
    Node<Character> d = new Node<>('d');
    Node<Character> e = new Node<>('e');
    Node<Character> f = new Node<>('f');

    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.right = f;

//        a
//       / \
//      b   c
//     / \   \
//    d   e   f

    DepthFirstValues dfv = new DepthFirstValues();
    Character[] characters = dfv.depthFirstValues(a); // a, b, d, e, c, f
    System.out.println(Arrays.toString(characters));
    List<Character> depthFirstValuesR = dfv.depthFirstValuesR(a, new ArrayList<>());
    System.out.println(depthFirstValuesR.toString());
  }

  /**
   * Time: O(n) where n = number of nodes in the tree.
   * Space: O(n)
   * @param root
   * @return
   */
  public Character[] depthFirstValues(Node<Character> root) {
    //check if root is valid
    if (root == null) {
      return null;
    }
    //create a list to store values of the tree
    List<Character> list = new ArrayList<>();

    //create a stack to depth first node traversal
    Stack<Node<Character>> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      //pop topmost node in stack
      Node<Character> currNode = stack.pop();
      //add node's value to list
      list.add(currNode.val);

      //add right node first to visit left node first on stack
      if (currNode.right != null) {
        stack.push(currNode.right);
      }
      if (currNode.left != null) {
        stack.push(currNode.left);
      }
    }
    Character[] values = new Character[list.size()];
    return list.toArray(values);
  }

  public List<Character> depthFirstValuesR(Node<Character> root, List<Character> values) {
    if (root == null) {
      return null;
    }

    values.add(root.val);
    depthFirstValuesR(root.left, values);
    depthFirstValuesR(root.right, values);
    return values;
  }
}
