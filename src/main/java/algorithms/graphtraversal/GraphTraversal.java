package algorithms.graphtraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Breath first search and depth first search can be used to traverse through a graph
 * <p>
 * The time complexity of BFS and DFS for a graph is O(V + E)
 * where V is the number of vertices or nodes and E is the number of edges.
 * <p>
 * The space complexity of graph traversal is O(V) where V is the number of nodes or vertices.
 */
public class GraphTraversal {

  public void depthFirstSearch(Node root) {
    Stack<Node> stack = new Stack<>();
    Set<Node> seen = new HashSet<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node curr = stack.pop();
      if (!seen.contains(curr)) {
        seen.add(curr);
        //process node;
        System.out.println(curr.id);
      }

      for (Node adjacent : curr.adjacents) {
        if (!seen.contains(adjacent)) {
          stack.push(adjacent);
        }
      }
    }
  }

  public void breathFirstSearch(Node root) {
    Queue<Node> queue = new LinkedList<>();
    Set<Node> seen = new HashSet<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node curr = queue.poll();

      if (!seen.contains(curr)) {
        seen.add(curr);
        //process node
        System.out.println(curr.id);
      }
      for (Node adjacent : curr.adjacents) {
        if (!seen.contains(adjacent)) {
          queue.add(adjacent);
        }
      }
    }
  }

  private class Node {

    int id;
    List<Node> adjacents;

    public Node(int id) {
      this.id = id;
      this.adjacents = new ArrayList<>();
    }
  }
}
