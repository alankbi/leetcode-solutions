/**
 * Problem 2: Add Two Numbers
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode((l1.val + l2.val) % 10);
        ListNode temp = sum;
        ListNode temp1 = l1.next;
        ListNode temp2 = l2.next;
        int carry = (l1.val + l2.val) / 10;

        while (temp1 != null || temp2 != null) {
            int val1 = temp1 == null ? 0 : temp1.val;
            int val2 = temp2 == null ? 0 : temp2.val;

            temp.next = new ListNode((val1 + val2 + carry) % 10);
            carry = (val1 + val2 + carry) / 10;

            if (temp1 != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return sum;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode sum = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(sum.toString());
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        public String toString() {
            String str =  "" + val;
            ListNode temp = next;

            while (temp != null) {
                str += " -> " + temp.val;
                temp = temp.next;
            }
            return str;
        }
    }
}
