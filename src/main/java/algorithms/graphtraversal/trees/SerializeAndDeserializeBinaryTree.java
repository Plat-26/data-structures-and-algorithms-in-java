package algorithms.graphtraversal.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection
 * link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary
 * tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with
 * different approaches yourself.
 */
public class SerializeAndDeserializeBinaryTree {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "X";
    }

    String leftSerial = serialize(root.left);
    String rightSerial = serialize(root.right);

    return root.val + "," + leftSerial + "," + rightSerial;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(data.split(",")));
    return deserialize(queue);
  }

  /**
   * @param queue
   * the queue ensures that whatever is at the front is the next node to
   * process, we don't need to carry state between calls because the queue
   * enforces that ordering itself
   * @return
   */
  private TreeNode deserialize(Queue<String> queue) {
    String value = queue.poll();
    if("X".equals(value)) {
      return null;
    }
    TreeNode node = new TreeNode(Integer.parseInt(value));
    node.left = deserialize(queue);
    node.right = deserialize(queue);
    return node;
  }


}
