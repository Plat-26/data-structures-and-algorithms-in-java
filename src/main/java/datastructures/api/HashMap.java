package datastructures.api;

public interface HashMap<K, V> {

  /**
   * Time: O(1)
   * @param key
   * @param value
   */
  void put(K key, V value);

  /**
   * Time: O(1)
   * @param key
   */
  void get(K key);
}
