package util;

import java.util.List;

// For Graphs
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public String toString() {
        StringBuilder str = new StringBuilder().append(this.val);
        if (this.neighbors != null) {
            str.append(" -");
            for (Node n : this.neighbors) {
                str.append(" ").append(n.val);
            }
        }
        return str.toString();
    }
}
