package com.bkatwal.leetcode.LinkedList;


import com.bkatwal.leetcode.util.LinkedList;
import com.bkatwal.leetcode.util.TwoPointers;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its
 * head.
 * <p>
 * Follow up: Could you do this in one pass?
 */
@TwoPointers
@LinkedList
public class RemoveGivenFromEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {

    if (head == null) {
      return null;
    }

    ListNode ptr1 = head;

    ListNode ptr2 = head;

    int i = 0;
    while (i < n && ptr1 != null) {
      ptr1 = ptr1.next;
      i++;
    }
    ListNode prev = null;

    while (ptr1 != null) {
      ptr1 = ptr1.next;
      prev = ptr2;
      ptr2 = ptr2.next;
    }

    if (prev != null) {
      prev.next = ptr2.next;
    } else {
      ListNode temp = ptr2.next;
      ptr2.next = null;

      return temp;
    }

    return head;
  }
}
