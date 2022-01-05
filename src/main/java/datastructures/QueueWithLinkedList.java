package datastructures;

public class QueueWithLinkedList<T> {

  private Node<T> front;
  private Node<T> rear;
  private int currentSize;

  public QueueWithLinkedList() {
    this.front = null;
    this.rear = null;
    currentSize = 0;
  }

  public static void main(String[] args) {
    QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
    queue.enqueue(4);
    queue.enqueue(5);
    System.out.println(queue.dequeue());
    queue.enqueue(6);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }

  /**
   * Adds an element to the queue
   *
   * @param element
   */
  public void enqueue(T element) {
    Node<T> newNode = new Node<>(element);

    if (this.rear == null) {
      this.front = this.rear = newNode;
      currentSize++;
    }
    this.rear.next = newNode;
    this.rear = newNode;
  }

  /**
   * Removes an element from the queue
   *
   * @return
   */
  public T dequeue() {
    if (this.front == null) {
      return null;
    }
    T element = this.front.value;
    this.front = this.front.next;
    //if front is null then change rear to null
    if (this.front == null) {
      this.rear = null;
    }
    currentSize--;
    return element;
  }

  private boolean isEmpty() {
    return currentSize == 0;
  }

  private class Node<T> {

    T value;
    Node next;

    public Node(T element) {
      this.value = element;
      this.next = null;
    }
  }
}
