package medium;

import util.TreeNode;

/**
 * Problem 654: Maximum Binary Tree
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMax(nums, 0, nums.length - 1);
    }

    private TreeNode constructMax(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMax(nums, left, maxIndex - 1);
        root.right = constructMax(nums, maxIndex + 1, right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode result = new MaximumBinaryTree().constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5});
        System.out.println(result);
    }
}
