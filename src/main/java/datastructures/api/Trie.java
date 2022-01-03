package datastructures.api;

public interface Trie {

  /**
   * Adds a new word to the trie.
   * Time: O(n) where n is the length of the word.
   * @param word
   */
  void insert(String word);
}
