package algorithms.graphtraversal.graphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given the source/root of a graph print all values in the graph by a breath first traversal.
 */
public class BreathFirstPrint {

  public static void main(String[] args) {
    GraphNode<Character> source = new GraphNode(
        'a', Arrays.asList(new GraphNode<>('d', Arrays.asList(new GraphNode<>("f", Collections.emptyList()))),
        new GraphNode<>('c', Arrays.asList(new GraphNode<>('e', Collections.emptyList()))))
    );

    BreathFirstPrint bf = new BreathFirstPrint();
    bf.breathFirstPrint(source);
  }

  public void breathFirstPrint(GraphNode<Character> source) {
    Queue<GraphNode<Character>> queue = new LinkedList<>();
    queue.add(source);
    Set<GraphNode<Character>> seen = new HashSet<>(); //Set is only required when the graph is cyclic

    while (!queue.isEmpty()) {
      GraphNode<Character> polled = queue.poll();
      System.out.println(polled.id);
      seen.add(polled);

      for (GraphNode<Character> node : polled.adjacents) {
        if (!seen.contains(node)) {
          queue.add(node);
        }
      }
    }
  }
}
