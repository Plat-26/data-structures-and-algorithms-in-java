package algorithms.graphtraversal.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {

   public static void main(String[] args) {
     TopologicalSort topSort = new TopologicalSort();
     topSort.findOrder(2, new int[][]{{0, 1}});
   }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
      //collect the dictionary of ongoing and outgoing edges
      Map<Integer, List<Integer>> ingoing = new HashMap<>();
      Map<Integer, List<Integer>> outgoing = new HashMap<>();

      for(int[] edge : prerequisites) {
        if(!ingoing.containsKey(edge[0])) {
          ingoing.put(edge[0], new ArrayList<>());
        }
        ingoing.get(edge[0]).add(edge[1]);

        if(!outgoing.containsKey(edge[1])) {
          outgoing.put(edge[1], new ArrayList<>());
        }
        outgoing.get(edge[1]).add(edge[0]);
      }

      Queue<Integer> queue = new LinkedList<>();
      //find the base case node
      for (int i = 0; i < numCourses; i++) {
        if(ingoing.getOrDefault(i, new ArrayList<>()).size() == 0) {
          queue.add(i);
        }
      }

      //create array to hold list of nodes
      List<Integer> taken = new ArrayList<>();

      //while node is not empty
      while(queue.size() > 0) {

        //take the node
        int curr = queue.poll();
        taken.add(curr);

        //for every edge in outgoing of curr node
        for(int node : outgoing.getOrDefault(curr, new ArrayList<>())) {
          //remove curr node in the ingoing dict
          ingoing.get(node).remove(Integer.valueOf(curr));
          //if length == o, add to list of nodes
          if(ingoing.get(node).size() == 0) {
            queue.add(node);
          }
        }
      }
      if(taken.size() == 0) {
        return new int[0];
      }
      int[] courses = new int[numCourses];
      for(int i = 0; i < taken.size(); i++) {
        courses[i] = taken.get(i);
      }
      return courses;
    }

}
