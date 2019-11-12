package medium;

import util.TreeNode;

/**
 * Problem 98: Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        return root.val > min && root.val < max &&
                isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean result = new ValidateBinarySearchTree().isValidBST(root);
        System.out.println(result);
    }
}
