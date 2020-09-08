package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem 103: Binary Tree Zigzag Level Order Traversal
 */
public class BinaryTreeZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // Null represents the end of a level

        List<List<Integer>> levels = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        while (queue.size() > 1) {
            TreeNode node = queue.remove();

            if (node == null) {
                levels.add(current);
                current = new ArrayList<>();
                queue.add(null);
            } else {
                current.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        levels.add(current);


        for (int i = 1; i < levels.size(); i += 2) {
            Collections.reverse(levels.get(i));
        }

        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = new BinaryTreeZigZag().zigzagLevelOrder(root);
        System.out.println(result);
    }
}
