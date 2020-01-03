package medium;

import util.ListNode;

/**
 * Problem 82: Remove Duplicates from Sorted List II
 */
public class RemoveDuplicatesSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (head != null) {
            boolean duplicate = false;
            while (head.next != null && head.next.val == head.val) {
                duplicate = true;
                head.next = head.next.next;
            }
            if (duplicate) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }

            head = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 3, 3, 4, 4, 5});
        ListNode result = new RemoveDuplicatesSortedList2().deleteDuplicates(head);
        System.out.println(result);
    }
}
