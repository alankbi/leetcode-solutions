package medium;

import util.ListNode;

import java.util.Stack;

/**
 * Problem 445: Add Two Numbers II
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode root = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int digit1 = s1.isEmpty() ? 0 : s1.pop();
            int digit2 = s2.isEmpty() ? 0 : s2.pop();

            int sum = digit1 + digit2 + carry;
            ListNode node = new ListNode(sum % 10);

            node.next = root;
            root = node;

            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        if (carry == 1) {
            ListNode node = new ListNode(carry);
            node.next = root;
            root = node;
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[] {7, 2, 4, 3});
        ListNode l2 = new ListNode(new int[] {5, 6, 4});

        ListNode result = new AddTwoNumbers2().addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
