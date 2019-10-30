package util;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode l, TreeNode r) {
        val = x;
        left = l;
        right = r;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        constructString(this, s);
        return s.toString();
    }

    private void constructString(TreeNode node, StringBuilder s) {
        if (node != null) {
            constructString(node.left, s);
            s.append(node.val).append(" ");
            constructString(node.right, s);
        }
    }
}
