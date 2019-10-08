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

    public ListNode(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Initialize with at least one value");
        }
        val = values[0];
        ListNode temp = this;
        for (int i = 1; i < values.length; i++) {
            temp.next = new ListNode(values[i]);
            temp = temp.next;
        }
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