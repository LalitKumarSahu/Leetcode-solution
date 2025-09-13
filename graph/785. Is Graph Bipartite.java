import java.util.*;

// tc-O(V+E)---v is the number of vertices and E is the numbers of edges->
// sc-O(V) -- storing colour for each node---------->
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int col[] = new int[n];
        Arrays.fill(col, -1); // Initialize all nodes as uncolored
        
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (col[i] == -1) { // If the node is unvisited
                q.add(i);
                col[i] = 0; // Color the first node with 0

                while (!q.isEmpty()) {
                    int curr = q.poll(); // Remove the front element

                    for (int neighbor : graph[curr]) { // Directly access adjacent nodes
                        if (col[neighbor] == -1) {
                            col[neighbor] = 1 - col[curr]; // Alternate coloring
                            q.add(neighbor);
                        } else if (col[neighbor] == col[curr]) { // If the neighbor has the same color
                            return false; // Not a bipartite graph
                        }
                    }
                }
            }
        }
        return true;
    }
}
