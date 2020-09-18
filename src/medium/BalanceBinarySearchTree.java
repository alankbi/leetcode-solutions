package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1382: Balance a Binary Search Tree
 */
public class BalanceBinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        constructListFromTree(root, list);

        return recurse(list, 0, list.size() - 1);
    }

    private TreeNode recurse(List<TreeNode> list, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = list.get(mid);
        root.left = recurse(list, left, mid - 1);
        root.right = recurse(list, mid + 1, right);

        return root;
    }

    private void constructListFromTree(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            constructListFromTree(root.left, list);
            list.add(root);
            constructListFromTree(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null, new TreeNode(2,
                null, new TreeNode(3,
                null, new TreeNode(4))));

        TreeNode result = new BalanceBinarySearchTree().balanceBST(root);
        System.out.println(result);
    }
}
