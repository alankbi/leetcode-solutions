package hard;

import util.ListNode;

/**
 * Problem 25: Reverse Nodes in k-Group
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        for (int i = 0; i < k - 1; i++) {
            head = head.next;
            if (head == null) {
                return temp;
            }
        }

        ListNode end = null;
        while (checkAheadByK(temp, k)) {
            if (end != null) {
                ListNode connector = end.next;
                for (int i = 0; i < k - 1; i++) {
                    connector = connector.next;
                }
                end.next = connector;
                end = null;
            }
            ListNode saved = null;
            ListNode prev = null;

            for (int i = 0; i < k; i++) {
                saved = temp.next;
                temp.next = prev;
                prev = temp;
                if (end == null) {
                    end = temp;
                }
                temp = saved;
            }
            end.next = saved;
        }

        return head;
    }

    private boolean checkAheadByK(ListNode head, int k) {
        int size = 0;
        while (head != null) {
            size++;
            if (size >= k) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode result = new ReverseNodesInKGroup().reverseKGroup(new ListNode(new int[] {1, 2, 3, 4, 5}), 2);
        System.out.println(result);
    }
}
