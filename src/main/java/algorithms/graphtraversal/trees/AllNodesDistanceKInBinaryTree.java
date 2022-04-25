package algorithms.graphtraversal.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 */
public class AllNodesDistanceKInBinaryTree {

  /**
   * Time: O(n) Space: O(n)
   */
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> result = new ArrayList<>();

    //convert tree to undirected graph
    Map<Integer, List<Integer>> graph = buildGraph(root);

    //bfs
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(target.val);

    int level = 0;
    while(!queue.isEmpty()) {
      if(level == k) {
        result.addAll(new ArrayList<>(queue));
        break;
      }
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        int curr = queue.poll();
        visited.add(curr);

        List<Integer> adjacents = graph.get(curr);
        for(int adj : adjacents) {
          if(!visited.contains(adj)) {
            queue.add(adj);
          }
        }
      }
      level++;

    }
    return result;
  }

  private Map<Integer, List<Integer>> buildGraph(TreeNode root) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      if(!graph.containsKey(curr.val)) {
        graph.put(curr.val, new ArrayList<>());
      }
      if(curr.left != null) {
        int left = curr.left.val;
        if(!graph.containsKey(left)) {
          graph.put(left, new ArrayList<>());
        }
        graph.get(curr.val).add(left);
        graph.get(left).add(curr.val);
        queue.add(curr.left);
      }

      if(curr.right != null) {
        int right = curr.right.val;
        if(!graph.containsKey(right)) {
          graph.put(right, new ArrayList<>());
        }
        graph.get(curr.val).add(right);
        graph.get(right).add(curr.val);
        queue.add(curr.right);
      }
    }
    return graph;
  }
}
