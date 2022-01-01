package datastructures;

public class SinglyLinkedList<T> {

  private Node<T> head;

  public SinglyLinkedList() {
    this.head = null;
  }

  public static void main(String[] args) {
    Node<Integer> node = new Node<>(5);
    node.next = new Node<>(4);
    node.next.next = new Node<>(3);
    node.next.next.next = new Node<>(2);

    SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
    linkedList.head = node;
    linkedList.insertAtStart(6);
    linkedList.traverse();

  }

  /**
   * To append to a linked list
   *
   * @param element
   */
  public void insertAtEnd(T element) {
    Node<T> newNode = new Node<>(element);

    if (this.head == null) {
      this.head = newNode;
    }
    Node<T> curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }

    curr.next = newNode;
  }

  /**
   * To insert at the start of a linked list
   *
   * @param element
   */
  public void insertAtStart(T element) {
    Node<T> newNode = new Node<>(element);

    if (this.head == null) {
      this.head = newNode;
    }

    newNode.next = head;
    head = newNode;
  }

  /**
   * Insert at a specific node in the list
   *
   * @param node
   */
  public void insertAtNode(Node<T> node, T element) {
    Node<T> curr = head;

    while (curr != null) {
      if (curr.value == node.value) {
        Node<T> temp = curr.next;
        Node<T> newNode = new Node<>(element);

        curr.next = newNode;
        newNode.next = temp;
        return;
      }
      curr = curr.next;
    }
  }

  /**
   * To traverse the linked list and print all elements
   */
  public void traverse() {
    if (this.head == null) {
      System.out.println("Linked list is empty");
      return;
    }

    Node<T> curr = this.head;
    while (curr != null) {
      System.out.println(curr.value);
      curr = curr.next;
    }
  }

  private static class Node<T> {

    T value;
    Node<T> next;

    public Node(T value) {
      this.value = value;
      this.next = null;
    }
  }
}
