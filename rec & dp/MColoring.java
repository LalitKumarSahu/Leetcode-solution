import java.util.ArrayList;
import java.util.List;

public class MColoring {
  class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        int[] color = new int[v];   // color array initially zero (no color)
        
        // Convert edge list into adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) graph.add(new ArrayList<>());
        
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        return solve(0, graph, color, m, v);
    }

    boolean solve(int node, List<List<Integer>> graph, int[] color, int m, int n) {
        if (node == n) return true; // All nodes colored

        for (int col = 1; col <= m; col++) {

            if (isSafe(node, graph, color, col)) {
                color[node] = col;

                if (solve(node + 1, graph, color, m, n)) return true;

                color[node] = 0; // BACKTRACK
            }
        }
        return false;
    }

    boolean isSafe(int node, List<List<Integer>> graph, int[] color, int col) {
        for (int adj : graph.get(node)) {
            if (color[adj] == col) return false;
        }
        return true;
    }
}

}
