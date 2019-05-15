package easy;

/**
 * Problem 21: Merge Two Sorted Lists
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode sortedList;
        if (l1.val < l2.val) {
            sortedList = l1;
            l1 = l1.next;
        } else {
            sortedList = l2;
            l2 = l2.next;
        }

        ListNode temp = sortedList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }

        return sortedList;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = new MergeTwoLists().mergeTwoLists(l1, l2);
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
