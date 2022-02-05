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
 * Write a function, shortestPath, that takes in an array of edges for an undirected graph
 * and two nodes (nodeA, nodeB). The function should return the length of the shortest path
 * between A and B. Consider the length as the number of edges in the path, not the number of nodes.
 * If there is no path between A and B, then return -1.
 * const edges = [
 *   ['w', 'x'],
 *   ['x', 'y'],
 *   ['z', 'y'],
 *   ['z', 'v'],
 *   ['w', 'v']
 * ];
 */
public class ShortestPath {

  public static void main(String[] args) {
    List<char[]> edgeList = Arrays.asList(new char[]{'w', 'x'}, new char[]{'x', 'y'},
        new char[]{'z', 'y'},
        new char[]{'z', 'v'}, new char[]{'w', 'v'});

    ShortestPath path = new ShortestPath();
    int shortest = path.shortestPath(edgeList, 'w', 'z');
    System.out.println(shortest);

  }
  /**
   * Breath first traversal gives the shortest distance!
   * @param edgeList
   * @return
   */
  public int shortestPath(List<char[]> edgeList, char nodeA, char nodeB) {
    Map<Character, List<Character>> graph = createGraph(edgeList);
    return findShortestPath(graph, nodeA, nodeB);
  }

  // v - z, w
  // w - x, v - nodeA - 0
  // x - w, y
  // y - x, z
  // z - y, v

  private int findShortestPath(Map<Character, List<Character>> graph, char nodeA, char nodeB) {
    //create a set to find visited nodes
    Set<Character> visited = new HashSet<>();
    //create a queue to set up the graph traversal
    //initialize queue with start point as object representing node and distance
    Queue<Object[]> queue = new LinkedList<>();
    queue.add(new Object[]{nodeA, 0});

    while (!queue.isEmpty()) {
      Object[] polled = queue.poll();
      char currNode = (char) polled[0];
      //represent distance of each node from the start point- nodeA
      int dist = (int) polled[1];

      //check if current node is the end of path, if so return distance from parent node
      if (currNode == nodeB) {
        return dist;
      }
      visited.add(currNode);

      //traverse through node adjacents.
      for (char adj : graph.get(currNode)) {
        if (!visited.contains(adj)) {
          //include nodes not seen before in queue and continued path with increased distance of 1
          queue.add(new Object[] {adj, dist + 1});
        }
      }
    }
    return -1;
  }

  private Map<Character, List<Character>> createGraph(List<char[]> edgeList) {
    Map<Character, List<Character>> graph = new HashMap<>();

    for (char[] edge : edgeList) {
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
