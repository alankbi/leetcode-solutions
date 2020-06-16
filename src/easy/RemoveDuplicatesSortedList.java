package easy;

import util.ListNode;

/**
 * Problem 83: Remove Duplicates from Sorted List
 */
public class RemoveDuplicatesSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 1, 2});

        ListNode result = new RemoveDuplicatesSortedList().deleteDuplicates(head);
        System.out.println(result);
    }
}
