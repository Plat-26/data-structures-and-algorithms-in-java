package algorithms.graphtraversal.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule2 {

  public static void main(String[] args) {
    CourseSchedule2 schedule2 = new CourseSchedule2();
    int[][] pre = new int[][] {{1,0},{2,0},{3,1},{3,2}};
    schedule2.findOrder(4, pre);
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
      if(prerequisites.length  <= 0) {
        return new int[0];
      }

      List<Integer> result = new ArrayList<>();
      Map<Integer, List<Integer>> adjList = createAdjacencyList(prerequisites);

      Set<Integer> visited = new HashSet<>();
      Queue<Integer> queue = new LinkedList<>();
      queue.add(prerequisites[0][1]);

      while(!queue.isEmpty() && result.size() < numCourses) {
        int val = queue.poll();
        visited.add(val);

        result.add(val);
        if(adjList.containsKey(val)) {
          for(int adj : adjList.get(val)) {
            if(!visited.contains(adj)) {
              queue.add(adj);
            }
          }
        }

      }
      int[] courses = new int[numCourses];
      for(int i = 0; i < courses.length; i++) {
        courses[i] = result.get(i);
      }
      return courses;

      //traverse adjacency list and each value to result list
      //return result list once it has the required size.
    }
    //create adjacency list from edge list
    //[[1,0],[2,0],[3,1],[3,2]]
    private Map<Integer, List<Integer>> createAdjacencyList(int[][] prerequisites) {
      Map<Integer, List<Integer>> adjList = new HashMap<>();
      for (int[] edge : prerequisites) {
        if(!adjList.containsKey(edge[1])) {
          adjList.put(edge[1], new ArrayList<>());
        }
        adjList.get(edge[1]).add(edge[0]);
      }
      return adjList;
    }
}
