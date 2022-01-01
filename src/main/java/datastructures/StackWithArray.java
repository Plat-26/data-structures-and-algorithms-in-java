package datastructures;

import java.util.ArrayList;
import java.util.List;

public class StackWithArray<T> {

  int size;
  int top;
  T[] stackArray; //using a list and array to show possible variations
  List<T> stackList;

  public StackWithArray(int size) {
    this.size = size;
    this.top = -1;
    this.stackArray = (T[]) new Object[size];
    this.stackList = new ArrayList<T>(size);
  }

  /**
   * Adds a new element to the stack
   *
   * @param element
   */
  public void push(T element) {
    if (!isFull()) {
      top++;
      stackArray[top] = element;
      stackList.add(top, element);
      System.out.println("Element added to stack");
    }
  }

  /**
   * Returns the top element from the stack
   *
   * @return
   */
  public T pop() {
    if (!isEmpty()) {
      T popped = stackArray[top]; // T popped = stackList.get(top);
      top--;
      return popped;
    }
    System.out.println("Stack is empty");
    return null;
  }

  /**
   * Retrieves the top element without removing from stack
   *
   * @return
   */
  public T peek() {
    return stackArray[top]; //stackList.get(top)
  }

  private boolean isEmpty() {
    return top == -1;
  }

  private boolean isFull() {
    return top == size - 1;
  }
}
