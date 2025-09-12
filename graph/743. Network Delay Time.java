class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>>adj = new ArrayList<>();

        for(int i=0; i<n; i++){ // 0, 1, 2 ... n-1
            adj.add(new ArrayList<>());
        }
        for(int [] time : times){
            int u = time[0]-1;
            int v = time[1]-1;
            int w = time[2];


            adj.get(u).add(new int[]{v,w});
        }
        int minTime[] = dijkstar(k-1, n, adj);

        int res = Integer.MIN_VALUE;

        for(int time: minTime){
            res = Math.max(res, time);
        }
      
      return (res == Integer.MAX_VALUE)?-1:res;
        
        
    }
    public int [] dijkstar(int src, int n,  List<List<int[]>>adj){ // n-vertices
        PriorityQueue<int[]>pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int p1[], int p2[]){
              return p1[1] - p2[1];
        }
        });

        int time[] = new int[n]; // dist array
        Arrays.fill(time, Integer.MAX_VALUE);
        time[src] = 0;

        pq.offer(new int[]{src, 0});

        while(!pq.isEmpty()){
            int pair[] = pq.poll();
            int u = pair[0];  // node
            int d = pair[1];  // dist

            if(d > time[u]) continue;

            for(int neighbor[]: adj.get(u)){
                int v = neighbor[0];
                int w = neighbor[1];

                if(time[u] + w < time[v]){
                    time[v] = time[u] + w;
                    pq.offer(new int[]{v, time[v]});
                }
            }
        }
        return time; 
       
    }
}