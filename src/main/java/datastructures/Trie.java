package datastructures;

/**
 * A tree data structure that optimizes search. Time complexity of search in a a trie is O(M) where
 * M is the length of the word.
 * <p>
 * In a trie every node represents a character and can have as children nodes characters that make
 * up the same prefix.
 * <p>
 * Java does not have a default implementation of a trie.
 */
public class Trie {

  private final Node root = new Node('\0');

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("word");
    System.out.println(trie.search("word"));
  }

    /**
     * Inserts a new word into the trie
     * @param word
     */
  public void insert(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      if (curr.children[c - 'a'] == null) {
        curr.children[c - 'a'] = new Node(c);
      }
      curr = curr.children[c - 'a'];
    }
    curr.isWord = true;
  }

    /**
     * Checks if given word is present in trie
     * @param word
     * @return
     */
  public boolean search(String word) {
    Node node = this.getNode(word);
    return node != null && node.isWord;
  }

    /**
     * Checks if a given prefix is present in trie
     * @param prefix
     * @return
     */
  public boolean isPrefix(String prefix) {
      return getNode(prefix) != null;
  }

  private Node getNode(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      if (curr.children[c - 'a'] == null) {
        return null;
      }
      curr = curr.children[c - 'a'];
    }
    return curr;
  }

  private class Node {

    char c;
    boolean isWord;
    Node[] children;

    public Node(char c) {
      this.c = c;
      this.isWord = false;
      this.children = new Node[26];
    }
  }
}
