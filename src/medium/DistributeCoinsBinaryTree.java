package medium;

import util.TreeNode;

/**
 * Problem 979: Distribute Coins in Binary Tree
 */
public class DistributeCoinsBinaryTree {

    private int score;

    public int distributeCoins(TreeNode root) {
        this.score = 0;

        recurse(root);
        return this.score;
    }

    private int recurse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDiff = recurse(root.left);
        int rightDiff = recurse(root.right);

        this.score += Math.abs(leftDiff) + Math.abs(rightDiff);

        return root.val + leftDiff + rightDiff - 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(0), new TreeNode(0));

        int result = new DistributeCoinsBinaryTree().distributeCoins(root);
        System.out.println(result);
    }
}
