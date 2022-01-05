package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * A graph is a collection of nodes and edges.
 * Nodes are data points on the graph while edges represents relationship between nodes.
 * <p>
 * A graph is said to be directed if there's an explicit direction that must be travelled between
 * two paths. The graph is undirected if movements between two nodes can be in any direction.
 * <p>
 * Weighted graphs are those that explicitly define the cost of travelling across an edge.
 * <p>
 * Programmatically, a graph can be represented by an adjacency matrix or an adjacency list.
 * The adjacency matrix is a 2 x 2 representation of the graph in which matrix[i][j] represents an
 * edge between nodes i and j. The value at this point can also be used to represent the weight of
 * that edge.
 * <p>
 * The adjacency list represents the matrix as a map where in the keys represent the nodes and the
 * values is a list of nodes connected to that key node.
 * <p>
 * Breath first search and depth first search are suitable means for traversing unweighted graphs.
 */
public class Graph {

  public void iterativeDFS(Node node) {
    Stack<Node> stack = new Stack<>();
    stack.add(node);

    while(!stack.isEmpty()) {
      Node curr = stack.pop();
      System.out.println(curr.id);

      //get all neighbours
      List<Node> adjacents = curr.adjacent;
      for(int i = 0; i < adjacents.size(); i++) {
        Node adj = adjacents.get(i);
        if(adj != null && !adj.visited) {
          stack.push(adjacents.get(i));
        }
      }
      curr.visited = true;
    }
  }

  public void breathFirstSearch(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while(!queue.isEmpty()) {
      Node curr = queue.poll();
      System.out.println(curr.id);

      List<Node> adjacents = curr.adjacent;
      for(int i = 0; i < adjacents.size(); i++) {
        Node adj = adjacents.get(i);
        if(adj != null && !adj.visited) {
          queue.add(adj);
        }
      }
      curr.visited = true;
    }
  }

  private static class Node {

    private int id;
    boolean visited;
    List<Node> adjacent;

    private Node(int id) {
      this.id = id;
      this.visited = false;
      this.adjacent = new ArrayList<>();
    }

    public void addAdjacent(Node adjacentNode) {
      this.adjacent.add(adjacentNode);
    }
  }
}
