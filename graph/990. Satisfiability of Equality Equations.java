class Solution {
    //total tc -- O(n · α(N)), where n is the number of equations and α(N) is nearly constant.
    //O(n) for storing != equations + O(1) for DSU → O(n)
    public boolean equationsPossible(String[] equations) {
        DisjointSet dsu = new DisjointSet(26);
        ArrayList<int[]>notEqlEdges = new ArrayList<>();
        for(String equation:equations ){
            int u = equation.charAt(0) - 'a';
            int v = equation.charAt(3) - 'a';
            // construct graph using "equla to" equations
            if(equation.charAt(1) == '='){
                dsu.unionBySize(u, v);
            } else{ // store not equal to equations
             notEqlEdges.add(new int[]{u, v});

            }

        }
        for(int edge[]: notEqlEdges){
            int u = edge[0];
            int v = edge[1];
            if(dsu.findRootParent(u) == dsu.findRootParent(v)){
                return false;
            }
        }
        return true;
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
    public int findRootParent(int node){
        if(node == par[node]){
            return node;
        }
        par[node] = findRootParent(par[node]);
        return par[node];
    }
    public boolean unionBySize(int node1, int node2){
        int rootPar1 = findRootParent(node1);
        int rootPar2 =  findRootParent(node2);

        if(rootPar1 == rootPar2){
            return false;
        }

        if(size[rootPar1] < size[rootPar2]){
            par[rootPar1] = rootPar2;
            size[rootPar2] += size[rootPar1];
        }else{
            par[rootPar2] = rootPar1;
            size[rootPar1] += size[rootPar2];
        }
        return true;
    }