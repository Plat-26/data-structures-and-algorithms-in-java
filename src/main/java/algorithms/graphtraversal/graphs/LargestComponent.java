package algorithms.graphtraversal.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Write a function, largestComponent, that takes in the adjacency list of an undirected graph.
 * The function should return the size of the largest connected component in the graph.
 */
public class LargestComponent {

  public static void main(String[] args) {
    LargestComponent comp = new LargestComponent();
    Map<Integer, List<Integer>> graph = comp.createExampleGraph();
    System.out.println(comp.largestComponent(graph));
  }

  /**
   * Time: O(e) == O(n^2) where e = number of edges
   * Space: O(n) where n = number of nodes
   * @param graph
   * @return
   */
  public int largestComponent(Map<Integer, List<Integer>> graph) {
    //largest = 0
    int largest = Integer.MIN_VALUE;
    //create a set to keep track of visited nodes
    Set<Integer> visited = new HashSet<>();

    //loop through every node in the graph
    for (int node : graph.keySet()) {
      //traverse nodes not present in visited and retrun connected component count
      if (!visited.contains(node)) {
        int componentCount = traverseAndCount(graph, node, visited);
        //compare largest with newly returned
        largest = Math.max(largest, componentCount);
      }
    }
    return largest; //return count
  }

  private int traverseAndCount(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
    if (visited.contains(node)) {
      return 0;
    }
    int count = 1;
    visited.add(node);
    for (int adj : graph.get(node)) {
        count += traverseAndCount(graph, adj, visited);
    }
    return count;
  }

  private int traverseIterative(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
    int count = 0;

    Stack<Integer> stack = new Stack<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      Integer currNode = stack.pop();
      if (!visited.contains(currNode)) {
        count++;
        visited.add(currNode);
      }
      for (int adj : graph.get(currNode)) {
        if (!visited.contains(adj)) {
          stack.push(adj);
        }
      }
    }
    return count;
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
