package hard;

import util.ListNode;
import java.util.PriorityQueue;

/**
 * Problem 23: Merge k Sorted Lists
 */
public class ReverseKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNodeWrapper> heap = new PriorityQueue<>();
        for (ListNode root : lists) {
            while (root != null) {
                heap.add(new ListNodeWrapper(root));
                root = root.next;
            }
        }

        if (heap.isEmpty()) {
            return null;
        }

        ListNode sorted = heap.remove().listNode;
        ListNode temp = sorted;
        while (!heap.isEmpty()) {
            temp.next = heap.remove().listNode;
            temp = temp.next;
        }
        temp.next = null;
        return sorted;
    }

    public static class ListNodeWrapper implements Comparable<ListNodeWrapper> {
        private ListNode listNode;

        public ListNodeWrapper(ListNode node) {
            listNode = node;
        }

        public int compareTo(ListNodeWrapper other) {
            return listNode.val - other.listNode.val;
        }
    }

    public static void main(String[] args) {
        ListNode[] lists = {
                new ListNode(new int[] {1, 4, 5}),
                new ListNode(new int[] {1, 3, 4}),
                new ListNode(new int[] {2, 6}),
        };

        ListNode result = new ReverseKSortedLists().mergeKLists(lists);
        System.out.println(result);
    }
}
