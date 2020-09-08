package medium;

import util.TreeNode;

/**
 * Problem 230: Kth Smallest Element in a BST
 */
public class KSmallestBST {

    private int count;
    private int kthElement;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        kthElement = 0;
        recurse(root, k);
        return kthElement;
    }

    private void recurse(TreeNode root, int k) {
        if (root != null) {
            recurse(root.left, k);

            count++;
            if (count == k) {
                kthElement = root.val;
            } else if (count < k) {
                recurse(root.right, k);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int result = new KSmallestBST().kthSmallest(root, 1);
        System.out.println(result);
    }
}
