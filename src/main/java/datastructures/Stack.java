package datastructures;

/**
 * An abstract data structure that uses the Last In First Out (LIFO) approach to storing and
 * retrieving data.
 * <p>
 * As with a stack of plates or a pile of books, the first element in is last to get out, the last
 * element in is the first to get out.
 * <p>
 * Operations possible with stack are: Push, Pop, Peek.
 * <p>
 * Elements are added at the tip and retrieved at the top. Insertion and look up takes O(1) constant
 * time.
 * <p>
 * Stacks can be implemented with an Array or a LinkedList
 * <p>
 * Java has a built in Stack class with peek, pop and push for retrieval, removal and insertion.
 * empty checks if stack is empty and search(object o) returns 1-based position of the object in the
 * stack
 */
public class Stack {

  public static void main(String[] args) {
    StackWithLinkedList<Integer> stack = new StackWithLinkedList<Integer>();
    stack.push(5);
    stack.push(4);
    stack.push(3);
    stack.push(2);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}

