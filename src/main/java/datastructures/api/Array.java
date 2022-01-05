package datastructures.api;

public interface Array<T> {

  /**
   * Inserts an element to the end of the array.
   * For all types of arrays and lists this takes O(1) time
   * @param element
   */
  void add(T element);

  /**
   * Insert an element at the specified index.
   * Time: O(n), Space: O(n) since all elements in the array will be moved during insertion
   * @param index
   * @param element
   */
  void insert(int index, T element);

  /**
   * Retrieves the element at the given array index.
   * Time: O(1) Space: O(1).
   * @param index
   * @return
   */
  T get(int index);

  /**
   * The Arrays.sort method give O(n log n) time complexity
   * @param array
   * @return
   */
  T[] sort(T[] array);
}
