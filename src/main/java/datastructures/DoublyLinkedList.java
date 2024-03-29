package datastructures;

/**
 * A doubly linked list has nodes that contains reference to its previous and next
 * nodes.
 */
public class DoublyLinkedList<T> {

  private Node<T> head;

  public static void main(String[] args) {
    DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
    ll.insertAtStart(1);
    ll.insertAtStart(2);
    ll.insertAtStart(3);
    ll.insertAtEnd(0);
    ll.insertAtNode(ll.head, 5);
    ll.print();

  }

  public void insertAtStart(T element) {
    Node<T> newNode = new Node<>(element);

    if (this.head == null) {
      this.head = newNode;
      return;
    }

    newNode.next = head;
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

  private void print() {
    if (head == null) {
      throw new IllegalStateException("List is empty");
    }

    Node<T> curr = head;
    while (curr != null) {
      System.out.println(curr.value);
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
