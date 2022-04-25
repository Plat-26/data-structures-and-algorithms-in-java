package algorithms.graphtraversal.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import javafx.util.Pair;

/**
 * You are given the root of a binary tree with n nodes.
 * Each node is uniquely assigned a value from 1 to n.
 * You are also given an integer startValue representing the value of the start node s,
 * and a different integer destValue representing the value of the destination node t.
 *
 * Find the shortest path starting from node s and ending at node t.
 * Generate step-by-step directions of such path as a string consisting of only the uppercase
 * letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
 *
 * 'L' means to go from a node to its left child node.
 * 'R' means to go from a node to its right child node.
 * 'U' means to go from a node to its parent node.
 * Return the step-by-step directions of the shortest path from node s to node t.
 *
 * Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
 * Output: "UURL"
 * Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
 */
public class StepByStepDirFromTreeNodeToAnother {

  /**
   * Time: O(N)
   * Space: O(N)
   */
  public String getDirections(TreeNode root, int startValue, int destValue) {
    //build graph {5:[1,L; 2,R;], 3:[1,U], 1:[5,U, 3,L]}
    //convert binary tree to undirected graph
    Map<Integer, List<Pair<Integer, String>>> graph = buildGraph(root);
    //keep track of visited nodes to avoid cycles
    Set<Integer> visited = new HashSet<>(); //3, 1, 5, 2
    //create a queue to traverse graph with bfs
    //Each entry in queue represents node value and the string of current path
    Queue<Pair<Integer, String>> queue = new LinkedList<>();
    queue.add(new Pair<>(startValue, "")); //2, 6, 4

    //bfs from one node to another
    while(!queue.isEmpty()) {
      Pair<Integer, String> node = queue.poll();
      int nodeValue = node.getKey();
      String dir = node.getValue();
      visited.add(nodeValue);

      if(nodeValue == destValue) {
        return dir;
      }

      List<Pair<Integer, String>> adjs = graph.get(nodeValue);
      for(Pair<Integer, String> adjNode : adjs) {
        if(!visited.contains(adjNode.getKey())) {
          queue.add(new Pair<>(adjNode.getKey(), dir + adjNode.getValue()));
        }
      }
    }
    return "";
  }

  //build graph such that adjacents include direction from source node
  private Map<Integer, List<Pair<Integer, String>>> buildGraph(TreeNode root) {
    Map<Integer, List<Pair<Integer, String>>> graph = new HashMap<>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      graph.computeIfAbsent(curr.val, k -> new ArrayList<>());
      if(curr.left != null) {
        int leftValue = curr.left.val;
        graph.computeIfAbsent(leftValue, k -> new ArrayList<>());
        graph.get(curr.val).add(new Pair<Integer, String>(leftValue, "L"));
        graph.get(leftValue).add(new Pair<Integer, String>(curr.val, "U"));
        queue.add(curr.left);
      }
      if(curr.right != null) {
        int rightValue = curr.right.val;
        graph.computeIfAbsent(rightValue, k -> new ArrayList<>());
        graph.get(curr.val).add(new Pair<Integer, String>(rightValue, "R"));
        graph.get(rightValue).add(new Pair<Integer, String>(curr.val, "U"));
        queue.add(curr.right);
      }
    }

    return graph;
  }
}
