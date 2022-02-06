package algorithms.graphtraversal.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Write a function, breathFirstValues, that takes in the root of a binary tree.
 * The function should return an array containing all values of the tree in breath-first order.
 */
public class BreathFirstValues {

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

    BreathFirstValues bfv = new BreathFirstValues();
    Character[] values = bfv.breathFirstValues(a);
    System.out.println(Arrays.toString(values));
  }

  public Character[] breathFirstValues(Node<Character> root) {
    if (root == null) {
      return null;
    }
    List<Character> values = new ArrayList<>();

    Queue<Node<Character>> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
      Node<Character> currNode = queue.poll();
      values.add(currNode.val);

      if (currNode.left != null) {
        queue.add(currNode.left);
      }
      if (currNode.right != null) {
        queue.add(currNode.right);
      }
    }
    Character[] arry = new Character[values.size()];
    return values.toArray(arry);
  }
}
