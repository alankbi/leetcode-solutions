package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Problem 399: Evaluate Division
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Set<Edge>> graph = new HashMap<>();

        // Construct graph where A -- n -- > B represents A/B = n
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);

            if (!graph.containsKey(a)) {
                graph.put(a, new HashSet<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new HashSet<>());
            }

            graph.get(a).add(new Edge(b, values[i]));
            graph.get(b).add(new Edge(a, 1 / values[i]));
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < result.length; i++) {
            List<String> query = queries.get(i);
            result[i] = bfs(graph, query.get(0), query.get(1));
        }

        return result;
    }

    // Multiplying the edge weights from A -> ... -> B will give the answer
    private double bfs(Map<String, Set<Edge>> graph, String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }

        Set<String> visited = new HashSet<>();
        Queue<Edge> queue = new ArrayDeque<>();
        queue.add(new Edge(start, 1.0));

        while (!queue.isEmpty()) {
            Edge node = queue.remove();
            visited.add(node.to);

            if (node.to.equals(end)) {
                return node.weight;
            }

            for (Edge edge : graph.get(node.to)) {
                if (!visited.contains(edge.to)) {
                    queue.add(new Edge(edge.to, edge.weight * node.weight));
                }
            }
        }

        return -1.0;
    }

    private static class Edge {
        private String to;
        private double weight;

        public Edge(String to, double weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int hashCode() {
            return to.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return this.to.equals(((Edge) o).to);
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] values = {2.0, 3.0};

        double[] result = new EvaluateDivision().calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }
}
