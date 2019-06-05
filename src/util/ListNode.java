package util;

public class ListNode {
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
        String str = "" + val;
        ListNode temp = next;

        while (temp != null) {
            str += "->" + temp.val;
            temp = temp.next;
        }
        return str;
    }
}