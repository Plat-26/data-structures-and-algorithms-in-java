package algorithms.graphtraversal.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Write a function, undirectedPath, that takes in an array of edges for an undirected graph
 * and two nodes (nodeA, nodeB). The function should return a boolean indicating whether or not
 * there exists a path between nodeA and nodeB.
 * e.g. const edges = [
 *   ['i', 'j'],
 *   ['k', 'i'],
 *   ['m', 'k'],
 *   ['k', 'l'],
 *   ['o', 'n']
 * ];
 */
public class UndirectedPath {

  public static void main(String[] args) {

    List<char[]> edgeList = Arrays.asList(new char[]{'i', 'j'}, new char[]{'k', 'i'},
        new char[]{'m', 'k'},
        new char[]{'k', 'l'}, new char[]{'o', 'n'});

    UndirectedPath path = new UndirectedPath();
    boolean hasPath = path.undirectedPath(edgeList, 'k', 'n');
    System.out.println(hasPath); //true
  }

  public boolean undirectedPath(List<char[]> edgeList, char nodeA, char nodeB) {
    Map<Character, List<Character>> graph = buildGraph(edgeList);
//    return hasPath(graph, nodeA, nodeB);
    return hasPathRecursive(graph, nodeA, nodeB, new HashSet<>());
  }

  /**
   * Time: O(e) == O(n^2) where e = number of edges.
   * Space: O(n) where n is equal to the number of nodes
   * @param graph
   * @param nodeA
   * @param nodeB
   * @return
   */
  public boolean hasPath(Map<Character, List<Character>> graph, char nodeA, char nodeB) {
    Set<Character> seen = new HashSet<>();
    Queue<Character> queue = new LinkedList<>();
    queue.add(nodeA);
    while (!queue.isEmpty()) {
      Character node = queue.poll();
      seen.add(node);
      if(node == nodeB) {
        return true;
      }
      for (Character neighbour : graph.get(node)) {
        if (!seen.contains(neighbour)) {
          queue.add(neighbour);
        }
      }
    }
    return false;
  }

  public boolean hasPathRecursive(Map<Character, List<Character>> graph, char src, char dest, Set<Character> visited) {
    if (visited.contains(src)) {
      return false;
    }
    if (src == dest) {
      return true;
    }
    visited.add(src);

    for (Character node : graph.get(src)) {
      if (hasPathRecursive(graph, node, dest, visited)) {
        return true;
      }
    }

    return false;
  }

  /**
   * From the array of edges represent the undirected graph as an adjacency list.
   * @param edges
   * @return
   */
  private Map<Character, List<Character>> buildGraph(List<char[]> edges) {
    //represent graph as a dictionary
    Map<Character, List<Character>> graph = new HashMap<>();
    for (char[] edge : edges) {
      char node1 = edge[0];
      char node2 = edge[1];
      if (!graph.containsKey(node1)) {
        graph.put(node1, new ArrayList<>());
      }
      if (!graph.containsKey(node2)) {
        graph.put(node2, new ArrayList<>());
      }
      graph.get(node1).add(node2);
      graph.get(node2).add(node1);
    }

    return graph;
  }
}
