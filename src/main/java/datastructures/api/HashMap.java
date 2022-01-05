package datastructures.api;

public interface HashMap<K, V> {

  /**
   * Average Time: O(1)
   * Worst Time: O(n)
   * @param key
   * @param value
   */
  void put(K key, V value);

  /**
   * Average Time: O(1)
   * Worst Time: O(n)
   * @param key
   */
  V get(K key);
}
