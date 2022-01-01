package datastructures;


/**
 * A linear data structure that stores list of similar elements by index
 * <p>
 * It is easy to look up elements with index It can represent multiple elements of same type with
 * single name Arrays can be used to implement other data structures like linked list, stack and
 * queue.
 * <p>
 * The number/ size of the array must be predefined and cannot be modified Insertion and deletion
 * from arrays require shifting of elements
 */
public class Array {

  private void initializeArray() {
    String[] animals = new String[3];
    animals[0] = "dog";
    animals[1] = "cat";
    animals[2] = "bird";

    String[] names = {"Love", "Faith", "Joy"};
  }
}
