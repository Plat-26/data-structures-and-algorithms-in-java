package datastructures;

public class StackWithLinkedList<T> {

  private Node<T> topNode;
  private int size;

  public StackWithLinkedList(int size) {
    this.topNode = null;
    this.size = size;
  }

  public void push(T element) {
    if (isFull()) {
      System.out.println("Stack is full");
      return;
    }
    Node<T> prevTop = topNode;
    topNode = new Node<T>(element);
    topNode.next = prevTop;
    size--;

    System.out.println("Element added to stack");
  }

  public T pop() {
    if (!isEmpty()) {
      T poppedElement = topNode.value;
      topNode = topNode.next;
      size--;

      return poppedElement;
    }
    System.out.println("Stack is empty");
    return null;
  }

  private boolean isFull() {
    return size == 0;
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
