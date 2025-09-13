class Solution {
    //tc- O(m * α(n)) ≈ O(m)  (since α(n) is almost constant), total loop = m connections
   // sc-O(n)
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1){ // jitna conc ki length hogi utni wire le sakte hai 
            return -1;
        }
        int wire = 0;
        DisjointSet dsu = new DisjointSet(n);
        for(int [] conection : connections){
            int u = conection[0];
            int v = conection[1];

            if(dsu.unionBySize(u, v)){ 
                wire++; // use wire
            }
        }
    
        return n-1-wire;
    }
 }
public class DisjointSet{
        int par[];
        int size[];

    DisjointSet(int nodes){
            this.par = new int[nodes];
            this.size = new int[nodes];

            for(int i=0; i<nodes; i++){
                this.par[i] = i;
                this.size[i] = 1;
            }
        }
    public int findParent(int node){
        if(node == par[node]){
            return node;
        }
        par[node] = findParent(par[node]);
        return par[node];
    }
    public boolean unionBySize(int node1, int node2){
        int rootParent1 = findParent(node1);
        int rootParent2 = findParent(node2);
        if(rootParent1 == rootParent2){
            return false;
        }
        if(size[rootParent1] <= size[rootParent2]){
            par[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        }else{
            par[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }
      return true;
    }
}
