package algorithms.graphtraversal.graphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Write a function, hasPath, that takes in an object
 * representing the adjacency list of a directed acyclic graph and two nodes (src, dst).
 * The function should return a boolean indicating whether or not
 * there exists a directed path between the source and destination nodes.
 */
public class HasPath {

  public static void main(String[] args) {
    GraphNode<Character> f = new GraphNode<>('f', Collections.emptyList());
    GraphNode<Character> g = new GraphNode<>('g', Collections.emptyList());
    GraphNode<Character> h = new GraphNode<>('h', Collections.emptyList());
    GraphNode<Character> i = new GraphNode<>('i', Collections.emptyList());
    GraphNode<Character> j = new GraphNode<>('j', Collections.emptyList());
    GraphNode<Character> k = new GraphNode<>('k', Collections.emptyList());


    f.setAdjacents(Arrays.asList(g, i));
    g.setAdjacents(Collections.singletonList(h));
    i.setAdjacents(Arrays.asList(g, k));
    j.setAdjacents(Collections.singletonList(i));

    HasPath path = new HasPath();
    System.out.println(path.hasPath(f, k)); //true
    System.out.println(path.hasPath(f, j)); //false
    System.out.println(path.hasPath(i, j)); //false
    System.out.println(path.hasPathRecursive(j, i)); //true
  }


  /**
   * Time: O(e) == O(n^2) where e = number of edges
   * Space: O(n) where n = number of nodes
   * @param source
   * @param dest
   * @return
   */
  public boolean hasPath(GraphNode<Character> source, GraphNode<Character> dest) {

    Stack<GraphNode<Character>> stack = new Stack<>();
    //initialize stack with source
    stack.push(source);
    //pop from stack
    while (!stack.isEmpty()) {
      GraphNode<Character> popped = stack.pop();
      //if popped == dest return true
      if (popped.equals(dest)) {
        return true;
      }
      //add popped's adjacent to stack
      for (GraphNode<Character> node: popped.adjacents) {
        stack.push(node);
      }
    }
    return false;
  }

  public boolean hasPathRecursive(GraphNode<Character> src, GraphNode<Character> dest) {
    if (src.equals(dest)) {
      return true;
    }

    for (GraphNode<Character> node : src.adjacents) {
      if (hasPathRecursive(node, dest)) {
        return true;
      }
    }
    return false;
  }
}
