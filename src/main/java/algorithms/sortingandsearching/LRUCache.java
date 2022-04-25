package algorithms.sortingandsearching;

import java.util.HashMap;

class LRUCache {
  //implement using a doubly linked list and hashMap
  private int capacity;
  private int size;
  private Node head;
  private Node tail;
  private HashMap<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    this.size = 0;
    this.map = new HashMap<>();

    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if(!map.containsKey(key)) {
      return -1;
    }

    Node curr = map.get(key);
    Node temp = curr.prev;
    curr.next.prev = temp;
    temp.next = curr.next;

    addToFront(curr);
    return curr.val;
  }

  public void put(int key, int value) {
    if(map.containsKey(key)) {
      Node curr = map.get(key);
      if(curr.val != value) {
        curr.val = value;
      }
      removeFromPosition(curr);
      addToFront(curr);
      return;
    }

    if(size == capacity) {
      //remove last index;
      Node last = tail.prev;
      last.prev.next = tail;
      tail.prev = last.prev;
      map.remove(last.key);
      this.size--;
    }

    Node node = new Node(key, value);
    addToFront(node);
    map.put(key, node);
    this.size++;
  }

  private void addToFront(Node node) {
    Node temp = this.head.next;
    this.head.next = node;
    node.prev = this.head;
    node.next = temp;
    temp.prev = node;
  }

  private void removeFromPosition(Node node) {
    Node temp1 = node.prev;
    Node temp2 = node.next;
    temp1.next = temp2;
    temp2.prev = temp1;
  }

  class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
      this.next = null;
      this.prev = null;
    }
  }
}