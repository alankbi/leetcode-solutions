package medium;

/**
 * Problem 19: Remove Nth Node From End of List
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        if (end == null) {
            return head.next;
        }

        ListNode temp = head;
        while (end.next != null) {
            temp = temp.next;
            end = end.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = new RemoveNthFromEnd().removeNthFromEnd(head, 2);
        System.out.println(result);
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public String toString() {
            String str = "" + val;
            ListNode temp = next;

            while (temp != null) {
                str += "->" + temp.val;
                temp = temp.next;
            }
            return str;
        }
    }
}
