// single component, n ->node, n->edge, undirected hai to cycyle pakka hogi jo node cycle form kar rhi hai use return karna hai
class Solution {
    //tc-O(N)--sc-O(N)---->
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] res = new int[2];
        DisjointSet dsu = new DisjointSet(n);

        for (int[] edge : edges) {
            if (!dsu.unionBySize(edge[0] - 1, edge[1] - 1)) { 
                res = edge;
            }
        }
        return res;
    }
    class DisjointSet {
        int[] par;
        int[] size;
        DisjointSet(int nodes) {
            par = new int[nodes];
            size = new int[nodes];
            for (int i = 0; i < nodes; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }
        int findRootParent(int node) {
            if (node == par[node]) return node;
            par[node] = findRootParent(par[node]); // path compression
            return par[node];
        }
        boolean unionBySize(int node1, int node2) {
            int root1 = findRootParent(node1);
            int root2 = findRootParent(node2);

            if (root1 == root2) return false;

            if (size[root1] < size[root2]) {
                par[root1] = root2;
                size[root2] += size[root1];
            } else {
                par[root2] = root1;
                size[root1] += size[root2];
            }
            return true;
        }
    }
}
