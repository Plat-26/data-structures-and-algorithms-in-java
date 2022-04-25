package algorithms.graphtraversal.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj]
 * represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result
 * in division by zero and that there is no contradiction.
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]],
 * values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 *
 */
public class EvaluateDivision {

  public double[] evaluateDivision(List<List<String>> equations, List<Double> values, List<List<String>> queries) {
    //build graph
    Map<String, Map<String, Double>> graph = buildGraph(equations, values);

    double[] result = new double[queries.size()];
    for(int i = 0; i < result.length; i++) {
      List<String> query = queries.get(i);
      String dividend = query.get(0);
      String divisor = query.get(1);
      //if dividend or divisor not in graph
      if(!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
        result[i] = -1d;
        continue;
      }
      if(dividend.equals(divisor)) {
        result[i] = 1d;
        continue;
      }
      //find path
      List<String> path = findPath(graph, dividend, divisor);
      //calculate
      result[i] = path == null ? -1d : calculate(graph, path);
    }
    return result;
  }

  private double calculate(Map<String, Map<String, Double>> graph, List<String> path) {
    double res = 1;
    int left = 0, right = 1;
    while(right < path.size()) {
      String leftNode = path.get(left);
      String rightNode = path.get(right);
      Map<String, Double> adj = graph.get(leftNode);
      res = res * adj.get(rightNode);
      left++; right++;
    }
    return res;
  }

  private List<String> findPath(Map<String, Map<String, Double>> graph, String src, String dest) {
    //create a pathMap with child - parent pairs using a dfs
    Map<String, String> pathMap = new HashMap<>();
    Set<String> visited = new HashSet<>();
    Stack<String> stack = new Stack<>();
    stack.push(src);

    while(!stack.isEmpty()) {
      String curr = stack.pop();
      visited.add(curr);
      if(curr.equals(dest)) {
        break;
      }
      for(String key: graph.get(curr).keySet()) {
        if(!visited.contains(key)) {
          pathMap.put(key, curr);
          stack.push(key);
        }
      }
    }
    if(!pathMap.containsKey(dest)) {
      return null;
    }
    //find path from pathMap
    List<String> path = new ArrayList<>();
    String curr = dest;
    while(curr != null) {
      path.add(curr);
      curr = pathMap.get(curr);
    }
    Collections.reverse(path);
    return path;
  }

  //build graph
  private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, List<Double> values) {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    for(int i = 0; i < values.size(); i++) {
      List<String> equation = equations.get(i);
      String dividend = equation.get(0);
      String divisor = equation.get(1);
      Double result = values.get(i);

      if(!graph.containsKey(dividend)) {
        graph.put(dividend, new HashMap<>());
      }
      if(!graph.containsKey(divisor)) {
        graph.put(dividend, new HashMap<>());
      }
      graph.get(dividend).put(divisor, result);
      graph.get(divisor).put(dividend, 1 / result);
    }
    return graph;
  }
}
