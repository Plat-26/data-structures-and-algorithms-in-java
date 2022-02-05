package algorithms.graphtraversal.graphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given the source/root of a graph print all values in the graph by a depth first traversal.
 */
public class DepthFirstPrint {

  public static void main(String[] args) {
    GraphNode<Character> source = new GraphNode(
        'a', Arrays.asList(new GraphNode<>('d', Arrays.asList(new GraphNode<>("f", Collections.emptyList()))),
        new GraphNode<>('c', Arrays.asList(new GraphNode<>('e', Collections.emptyList()))))
    );

    DepthFirstPrint df = new DepthFirstPrint();
    df.depthFirstPrint(source);
    System.out.println();

    /**
     * To avoid null checks initialize adjacent as empty list
     */
    GraphNode<Character> a = new GraphNode<>('a', Collections.emptyList());
    GraphNode<Character> b = new GraphNode<>('b', Collections.emptyList());
    GraphNode<Character> c = new GraphNode<>('c', Collections.emptyList());
    GraphNode<Character> d = new GraphNode<>('d', Collections.emptyList());
    GraphNode<Character> e = new GraphNode<>('e', Collections.emptyList());
    GraphNode<Character> f = new GraphNode<>('f', Collections.emptyList());

    a.setAdjacents(Arrays.asList(b, c));
    b.setAdjacents(Collections.singletonList(d));
    c.setAdjacents(Collections.singletonList(e));
    d.setAdjacents(Collections.singletonList(f));

    df.depthFirstPrintRecursive(a);
  }

  public void depthFirstPrint(GraphNode<Character> source) {
    Stack<GraphNode<Character>> stack = new Stack<>();
    stack.push(source);
    Set<GraphNode<Character>> seen = new HashSet<>();

    while (!stack.isEmpty()) {
      GraphNode<Character> popped = stack.pop();
      System.out.println(popped.id);
      seen.add(popped);


//      if(popped.adjacents == null) {
//        continue;
//      }
      for (GraphNode<Character> node : popped.adjacents) {
        if (!seen.contains(node)) {
          stack.push(node);
        }
      }
    }
  }

  public void depthFirstPrintRecursive(GraphNode<Character> source) {
    System.out.println(source.id);
    for (GraphNode<Character> node : source.adjacents) {
      depthFirstPrintRecursive(node);
    }
  }

}
