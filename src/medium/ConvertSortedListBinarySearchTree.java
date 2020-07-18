package medium;

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 109: Convert Sorted List to Binary Search Tree
 */
public class ConvertSortedListBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return sortedListToBST(list, 0, list.size() - 1);
    }

    private TreeNode sortedListToBST(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = sortedListToBST(list, left, mid - 1);
        root.right = sortedListToBST(list, mid + 1 , right);

        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {-10, -3, 0, 5, 9});

        TreeNode result = new ConvertSortedListBinarySearchTree().sortedListToBST(head);
        System.out.println(result);
    }
}
