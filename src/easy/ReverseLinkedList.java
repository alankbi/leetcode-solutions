package easy;

import util.ListNode;

/**
 * Problem 206: Reverse Linked List
 */
public class ReverseLinkedList {

    // Iterative solution
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    // Recursive solution
    public ListNode reverseListRecursively(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode next = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    public static void main(String[] args) {
        ListNode result = new ReverseLinkedList().reverseList(new ListNode(new int[] {1, 2, 3, 4, 5}));
        System.out.println(result);
    }
}
