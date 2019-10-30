package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 95: Unique Binary Search Trees II
 */
public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Arrays.asList(new TreeNode(n));
        }

        List<TreeNode> trees = new ArrayList<>();
        List<TreeNode> subtrees = generateTrees(n - 1);
        for (TreeNode subtree : subtrees) {
            TreeNode root = new TreeNode(n);
            root.left = subtree;
            trees.add(root);

            int numRightNodes = numRightNodes(subtree);
            for (int i = 0; i < numRightNodes; i++) {
                root = new TreeNode(subtree.val);
                TreeNode subtreePointer = subtree;
                root.left = subtreePointer.left;

                TreeNode current = root;
                for (int j = 0; j < i; j++) {
                    current.right = new TreeNode(subtreePointer.right.val);
                    current.right.left = subtreePointer.right.left;
                    current = current.right;
                    subtreePointer = subtreePointer.right;
                }

                current.right = new TreeNode(n);
                if (subtreePointer.right != null) {
                    current.right.left = subtreePointer.right;
                }

                trees.add(root);
            }
        }

        return trees;
    }

    private int numRightNodes(TreeNode root) {
        int count = 0;
        while (root != null) {
            root = root.right;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        List<TreeNode> result = new UniqueBinarySearchTrees2().generateTrees(3);
        System.out.println(result);
    }
}
