package algorithms.stringsandarrays;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode curr = head;
    int rem = 0;
    while(l1 != null || l2 != null) {
      int sum = rem;
      if(l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if(l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      rem = sum / 10;
    }
    if(rem > 0) {
      curr.next = new ListNode(rem);
    }
    return head.next;
  }

  class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
