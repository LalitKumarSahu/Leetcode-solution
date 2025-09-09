class Solution {
    class Pair implements Comparable <Pair>{
        String video;
        int freq;
        Pair(String video, int freq){
            this.video = video;
            this.freq = freq;
        }
        public int compareTo(Pair  p2){
            if(this.freq ==  p2.freq){
                return this.video.compareTo(p2.video);
            }
           return this.freq - p2.freq;
        }

    }
    // tc-O(N) + O(N) + NlogN--bfs + level + custom sorting--in best case n == k --k is the number keys(level)
    // sc-o(N) + O(N) + O(N) --queue + map + sort
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        // BFS
        Queue<Integer>q = new LinkedList<>();
        HashSet<Integer>vis = new HashSet<>();

        q.add(id);
        vis.add(id);
        int currLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int currId = q.remove();
                for(int friend : friends[currId]){
                    if(!vis.contains(friend)){
                        vis.add(friend);
                        q.add(friend);
                    }
                }

            }
            currLevel++;
            if(currLevel == level){
                break;
            }
        }
      //--- map me video aur uski freq--->
        HashMap<String, Integer>map = new HashMap<>();
        while(!q.isEmpty()){
            int currId = q.remove();
            for(String video : watchedVideos.get(currId)){ // yha she us id ka video aa jayega
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }

        List<Pair>videoList = new ArrayList<>();
        for(String video : map.keySet()){ // according to the freq ham sort karenge aur freq equal to lexixcal order
            videoList.add(new Pair(video, map.get(video)));
        }
        Collections.sort(videoList);
        List<String>res = new ArrayList<>();
        for(Pair pair : videoList){
            res.add(pair.video);
        }
        return res;

    }
}