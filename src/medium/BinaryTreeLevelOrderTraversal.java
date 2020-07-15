package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 102: Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        return result;
    }

    private void levelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        levelOrder(root.left, level + 1, result);
        levelOrder(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        System.out.println(result);
    }
}
