package datastructures;

/**
 * To implement a stack with a linked list, push at the top and pop at the top.
 * Only keep track of the head node.
 * @param <T>
 */
public class StackWithLinkedList<T> {

  private Node<T> topNode;

  public StackWithLinkedList() {
    this.topNode = null;
  }

  public void push(T element) {
    if (topNode == null) {
      topNode = new Node<>(element);
      return;
    }
    Node<T> prevTop = topNode;
    topNode = new Node<T>(element);
    topNode.next = prevTop;
    System.out.println("Element added to stack");
  }

  public T pop() {
    if (!isEmpty()) {
      T poppedElement = topNode.value;
      topNode = topNode.next;

      return poppedElement;
    }
    System.out.println("Stack is empty");
    return null;
  }


  private boolean isEmpty() {
    return topNode == null;
  }

  private class Node<T> {

    T value;
    Node<T> next;

    public Node(T value) {
      this.value = value;
      this.next = null;
    }
  }
}
