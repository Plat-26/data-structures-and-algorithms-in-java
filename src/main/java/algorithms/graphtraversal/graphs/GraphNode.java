package algorithms.graphtraversal.graphs;

import java.util.List;

/**
 * Represents a graph implemented as an adjacency list where every vertex of the graph has an id and
 * a corresponding list of adjacent nodes or neighbours.
 */
public class GraphNode<T> {

  T id;
  List<GraphNode<T>> adjacents;

  public GraphNode(T id, List<GraphNode<T>> adjacents) {
    this.id = id;
    this.adjacents = adjacents;
  }

  public T getId() {
    return id;
  }

  public void setId(T id) {
    this.id = id;
  }

  public List<GraphNode<T>> getAdjacents() {
    return adjacents;
  }

  public void setAdjacents(List<GraphNode<T>> adjacents) {
    this.adjacents = adjacents;
  }
}
