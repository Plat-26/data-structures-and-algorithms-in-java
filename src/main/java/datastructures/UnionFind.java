package datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * The union find data structure performs two operations on disjointed sets:
 * union: connect two objects/sets
 * find: determine if there's a path connecting one object/set to another
 * <p>
 * The union-find data structure is implemented as an array.
 * The initial state of this array is such that all nodes point to themselves as parent
 * <p>
 * Since every sub set has a parent it points to, the union of two sub sets is achieved
 * by making both subset have the same parent.
 * Finding a subset within another is to determine if both sub sets have the same parent.
 */
public class UnionFind {

  /**
   * To illustrate the union find data structure, the method counts the number of connected
   * components in a graph given the number of nodes, n and the list of edges.
   * @param n
   * @param edges
   * @return
   */
  private int countConnectedComponents(int n, int[][] edges) {
    int[] parents = new int[n];
    //initially, all nodes point to themselves as parents
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }
    //join the connected components as given by the list of edges.
    for (int[] edge : edges) {
      union(edge[0], edge[1], parents);
    }
    Set<Integer> set = new HashSet<>();
    //count the number of parents
    for (int i = 0; i < parents.length; i++) {
      set.add(find(i, parents));
    }
    return set.size();
  }

  /**
   * Union is implemented by setting the parent of one of the edges as equal to the other's parent
   * @param node1
   * @param node2
   */
  public void union(int node1, int node2, int[] parents) {
    int parent1 = find(node1, parents);
    int parent2 = find(node2, parents);
    parents[parent1] = parent2;
  }

  /**
   * Find is implemented by finding the parent of the node.
   * @param node
   * @param parents
   * @return
   */
  public int find(int node, int[] parents) {
    if (parents[node] != node) {
      parents[node] = find(parents[node], parents);
    }
    return parents[node];
  }
}
