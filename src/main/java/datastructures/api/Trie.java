package datastructures.api;

public interface Trie {

  /**
   * Adds a new word to the trie.
   * Time: O(n) where n is the length of the word.
   * @param word
   */
  void insert(String word);

  /**
   * To check if a word is in the trie
   * Time: O(n) where n is the length of the word.
   * @param word
   * @return
   */
  boolean search(String word);
}
