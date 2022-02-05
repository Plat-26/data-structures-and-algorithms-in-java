package algorithms.graphtraversal.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Write a function, connectedComponentsCount, that takes in the adjacency list of an undirected graph.
 * The function should return the number of connected components within the graph.
 * connectedComponentsCount({
 *   0: [8, 1, 5],
 *   1: [0],
 *   5: [0, 8],
 *   8: [0, 5],
 *   2: [3, 4],
 *   3: [2, 4],
 *   4: [3, 2]
 * }); // -> 2
 */
public class ConnectedComponentCount {

  public static void main(String[] args) {
    ConnectedComponentCount count = new ConnectedComponentCount();
    Map<Integer, List<Integer>> graph = count.createExampleGraph();
    System.out.println(count.connectedCount(graph));

  }

  public int connectedCount(Map<Integer, List<Integer>> graph) {
    int count = 0;

    Set<Integer> visited = new HashSet<>();
    //iterate through all the graph nodes
    for (int node : graph.keySet()) {
      //if node is not visited - indicates a new component, start a traversal.
      if (!visited.contains(node)) {
        traverseNode(graph, node, visited);
        count++; //increase count
      }
    }
    return count;
  }

  private void traverseNode(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      int currNode = queue.poll();
      visited.add(currNode);

      for (int adjacent : graph.get(currNode)) {
        if (!visited.contains(adjacent)) {
          queue.add(adjacent);
        }
      }
    }
  }

  private Map<Integer, List<Integer>> createExampleGraph() {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    graph.put(0, Arrays.asList(8, 1, 5));
    graph.put(1, Arrays.asList(0));
    graph.put(5, Arrays.asList(8, 0));
    graph.put(8, Arrays.asList(0, 5));
    graph.put(2, Arrays.asList(3, 4));
    graph.put(3, Arrays.asList(2, 4));
    graph.put(4, Arrays.asList(3, 2));
    return graph;
  }
}
