package medium;

import util.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Problem 133: Clone Graph
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (!oldToNew.containsKey(current)) {
                oldToNew.put(current, new Node());
                oldToNew.get(current).val = current.val;
            }

            Node copy = oldToNew.get(current);
            List<Node> neighbors = new ArrayList<>();
            for (Node n : current.neighbors) {
                Node neighbor;
                if (!oldToNew.containsKey(n)) {
                    neighbor = new Node();
                    neighbor.val = n.val;
                    oldToNew.put(n, neighbor);
                    queue.add(n);
                } else {
                    neighbor = oldToNew.get(n);
                }
                neighbors.add(neighbor);
            }
            copy.neighbors = neighbors;
        }

        return oldToNew.get(node);
    }

    public static void main(String[] args) {
        Node[] nodes = {
            null,
            new Node(1),
            new Node(2),
            new Node(3),
            new Node(4),
        };
        nodes[1].neighbors = Arrays.asList(nodes[2], nodes[4]);
        nodes[2].neighbors = Arrays.asList(nodes[1], nodes[3]);
        nodes[3].neighbors = Arrays.asList(nodes[2], nodes[4]);
        nodes[4].neighbors = Arrays.asList(nodes[1], nodes[3]);

        Node result = new CloneGraph().cloneGraph(nodes[1]);
        System.out.println(result);
    }
}
