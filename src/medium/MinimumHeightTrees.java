package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 310: Minimum Height Trees
 */
public class MinimumHeightTrees {

    private List<List<Integer>> graph;
    private boolean[] visited;

    private int maxDepth;
    private int endpoint;
    private List<Integer> ans = null;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];
        maxDepth = 0;
        endpoint = 0;

        // Choose a leaf node as the starting vertex
        // to find an endpoint on the longest path
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                findEndpoint(i, 0);
                break;
            }
        }
        int endpoint1 = endpoint;

        // Find other endpoint given one of the endpoints
        visited = new boolean[n];
        maxDepth = 0;
        findEndpoint(endpoint1, 0);

        // Find the 1 or 2 midpoints given the two endpoints, which
        // will be the vertices with the shortest heights
        List<Integer> order = new ArrayList<>();
        visited = new boolean[n];
        findMidpoint(endpoint1, order);

        return ans;
    }

    private void findMidpoint(int vertex, List<Integer> order) {
        visited[vertex] = true;
        order.add(vertex);

        if (vertex == endpoint) {
            if (maxDepth % 2 == 0) {
                ans = Arrays.asList(order.get(maxDepth / 2));
            } else {
                ans = Arrays.asList(order.get(maxDepth / 2), order.get(maxDepth / 2 + 1));
            }
            return;
        }

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                findMidpoint(neighbor, order);
            }
        }

        order.remove(order.size() - 1);
    }

    private void findEndpoint(int vertex, int depth) {
        visited[vertex] = true;
        if (depth > maxDepth) {
            maxDepth = depth;
            endpoint = vertex;
        }

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                findEndpoint(neighbor, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
            {1, 0},
            {1, 2},
            {1, 3},
        };

        List<Integer> result = new MinimumHeightTrees().findMinHeightTrees(4, edges);
        System.out.println(result);
    }
}
