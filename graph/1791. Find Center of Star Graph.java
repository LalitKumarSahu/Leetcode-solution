class Solution {
    // tc:O(E), SC:O(V)
    public int findCenter(int[][] edges) {
       HashMap<Integer, Integer>hm = new HashMap<>();
       int totalEdge = edges.length;

       for(int i=0; i<totalEdge; i++){
        int v1 = edges[i][0];
        int v2 = edges[i][1];

        hm.put(v1, hm.getOrDefault(v1, 0) + 1);
        hm.put(v2, hm.getOrDefault(v2, 0) + 1);

        if(hm.get(v1) == totalEdge){
            return v1;
        }
        if(hm.get(v2) == totalEdge){
            return v2;
        }
       }
       return -1;
        
    }
}

// m-2
class Solution {
    // tc:O(1)
    public int findCenter(int[][] edges) {
      int pair1[] =  edges[0]; //[v1,v2]
      int pair2[] = edges[1]; //[v1, v3] or [v3, v1]

      if( pair1[0] == pair2[0] || pair1[0] == pair2[1]){
        return pair1[0];
      }
      return pair1[1];
     
    }
}
