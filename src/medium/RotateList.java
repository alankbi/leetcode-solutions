package medium;

import util.ListNode;

/**
 * Problem 61: Rotate List
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = length(head);
        k %= length;

        if (k <= 0) {
            return head;
        }

        ListNode temp = head;
        for (int i = 0; i < length - k - 1; i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;
        return newHead;
    }

    private int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 3, 4, 5});
        ListNode result = new RotateList().rotateRight(head, 2);
        System.out.println(result);
    }
}
