package medium;

import util.ListNode;

/**
 * Problem 24: Swap Nodes in Pairs
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;

        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            if (temp != null) {
                head.next = temp.next;
                temp.next = head;

                if (prev != null) {
                    prev.next = temp;
                }
            }

            prev = head;
            head = head.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode result = new SwapNodesInPairs().swapPairs(head);
        System.out.println(result);
    }
}
