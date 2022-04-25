package algorithms.graphtraversal.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given a undirected graph with corresponding edges. Find the number of possible triangles?
 * Example:
 * 0 1
 * 2 1
 * 0 2
 * 4 1
 */
public class CountTriangles {

  private int countTriangles(List<int[]> edges, int source) {
    int count = 0;
    Map<Integer, List<Integer>> adjList = buildGraph(edges);

    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);

    while(!queue.isEmpty()) {
      int currNode = queue.poll();
      visited.add(currNode);
      List<Integer> adjacents = adjList.get(currNode);
      for(int adj : adjacents) {
        List<Integer> adjs = adjList.get(adj);
        count += adjs.stream().filter(c -> adjacents.contains(c)
            && c != currNode
            && !visited.contains(c)).count();

        adjacents.remove(adj);
        if(!visited.contains(adj)) {
          queue.add(adj);
        }
      }
    }
    return count;
  }

  private Map<Integer, List<Integer>> buildGraph(List<int[]> edges) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    for(int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];

      if(!adjList.containsKey(a)) {
        adjList.put(a, new ArrayList<>());
      }
      if(!adjList.containsKey(a)) {
        adjList.put(b, new ArrayList<>());
      }
      adjList.get(a).add(b);
      adjList.get(b).add(a);
    }
    return adjList;
  }
}