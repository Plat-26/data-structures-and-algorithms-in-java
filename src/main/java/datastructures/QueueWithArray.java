package datastructures;

public class QueueWithArray<T> {

  int capacity;
  int front;
  int rear;
  int currentSize;
  T[] queueList;

  public QueueWithArray(int size) {
    this.capacity = size;
    this.front = 0;
    this.rear = -1;
    this.currentSize = 0;
    this.queueList = (T[]) new Object[size];
  }

  public static void main(String[] args) {
    QueueWithArray<Integer> queue = new QueueWithArray<>(3);

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println(queue.dequeue()); //1
    queue.enqueue(4);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    queue.enqueue(3);
    System.out.println(queue.dequeue());

  }


  public void enqueue(T element) {
    if (isFull()) {
      throw new IllegalStateException("Queue is full");
    }
    rear++;
    currentSize++;
    queueList[rear] = element;
  }

  public T dequeue() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return null;
    }

    T element = queueList[front];
    front++;
    currentSize--;
    return element;
  }

  private boolean isFull() {
    if (currentSize < capacity && rear == capacity - 1) {
      rear = -1;
    }
    return currentSize == capacity;
  }

  private boolean isEmpty() {
    if (front >= capacity) {
      front = 0;
    }
    return currentSize == 0;
  }
}
