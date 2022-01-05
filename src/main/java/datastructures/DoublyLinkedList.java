package datastructures;

/**
 * The nodes of a doubly linked list has nodes that contains reference to its previous and next
 * nodes.
 */
public class DoublyLinkedList<T> {

  private Node<T> head;

  public void insertAtStart(T element) {
    Node<T> newNode = new Node<>(element);

    if (this.head == null) {
      this.head = newNode;
    }

    head.prev = newNode;
    this.head = newNode;
  }

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
    newNode.prev = curr;
  }

  public void insertAtNode(Node<T> node, T element) {
    Node<T> newNode = new Node<>(element);

    //1- 2- 3- 4
    Node<T> curr = head;
    while (curr != null) {
      if (curr.value == node.value) {
        Node<T> temp = curr.next;

        newNode.prev = curr;
        curr.next = newNode;
        temp.prev = newNode;
        newNode.next = temp;
      }
      curr = curr.next;
    }
  }

  private static class Node<T> {

    T value;
    Node<T> prev;
    Node<T> next;

    public Node(T value) {
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }
}
