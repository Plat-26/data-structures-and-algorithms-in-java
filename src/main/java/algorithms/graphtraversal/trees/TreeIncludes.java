package algorithms.graphtraversal.trees;

import java.util.Stack;

/**
 * Write a function, treeIncludes, that takes in the root of a binary tree and a target value.
 * The function should return a boolean indicating whether the value is contained in the tree.
 */
public class TreeIncludes {

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

    TreeIncludes treeIncludes = new TreeIncludes();
    boolean includes = treeIncludes.treeIncludes(a, 'e');//true
    System.out.println(includes);
    boolean includes2 = treeIncludes.treeIncludesR(a, 'h');//true
    System.out.println(includes2); //false
  }


  public boolean treeIncludes(Node<Character> root , char value) {
    Stack<Node<Character>> st = new Stack<>();
    st.push(root);

    while (!st.isEmpty()) {
      Node<Character> curr = st.pop();
      if (curr.val == value) {
        return true;
      }

      if (curr.right != null) {
        st.push(curr.right);
      }
      if (curr.left != null) {
        st.push(curr.left);
      }
    }
    return false;
  }

  public boolean treeIncludesR(Node<Character> node, char value) {
    if (node == null) {
      return false;
    }

    if (node.val == value) {
      return true;
    }
    return treeIncludes(node.left, value) || treeIncludes(node.right, value);
  }
}
