package medium;

import util.ListNode;

/**
 * Problem 86: Partition List
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        head = new ListNode(-1, head);
        ListNode beginning = new ListNode(-1);

        ListNode curr = head;
        ListNode beginningCurr = beginning;

        while (curr.next != null) {
            if (curr.next.val < x) {
                beginningCurr.next = curr.next;
                beginningCurr = beginningCurr.next;
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        beginningCurr.next = head.next;
        return beginning.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 4, 3, 2, 5, 2});

        ListNode result = new PartitionList().partition(head, 3);
        System.out.println(result);
    }
}
