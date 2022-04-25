package algorithms.sortingandsearching;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {

    ListNode head = new ListNode(0);
    ListNode point = head;

    PriorityQueue<ListNode> heap = new PriorityQueue<>(new NodeComparator());
    for(int i = 0; i < lists.length; i++) {
      ListNode curr = lists[i];
      if(curr != null) {
        heap.add(curr);
      }
    }

    while(!heap.isEmpty()) {
      ListNode node = heap.poll();
      point.next = node;
      point = point.next;

      if(node.next != null) {
        heap.add(node.next);
      }
    }
    return head.next;
  }
}

class NodeComparator implements Comparator<ListNode> {

  public int compare(ListNode k1, ListNode k2) {
    if (k1.val > k2.val) {
      return 1;
    } else if (k1.val < k2.val) {
      return -1;
    }
    return 0;
  }
}

