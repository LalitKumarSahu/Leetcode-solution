import java.util.*;

class Solution {
    public List<String> getNeighbors(String word, HashSet<String> set) {
        List<String> neighbors = new ArrayList<>();
        
        for (int i = 0; i < word.length(); i++) { // 3 - 0,1,2
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i)) {
                    continue;
                }
                String newWord = word.substring(0, i) + ch + word.substring(i + 1);
                
                if (set.contains(newWord)) {
                    neighbors.add(newWord);  // Add to neighbors instead of modifying set
                }
            }
        }
        return neighbors;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       HashSet<String> set = new HashSet<>(wordList);

       if(!set.contains(endWord)){
         return 0;
       }

        // If beginWord is already present in wordList(set), then remove it
         if(set.contains(beginWord)){
             set.remove(beginWord);
       }
       int level = 0;
       Queue<String>q = new LinkedList<>();
       q.add(beginWord);

        // BFS
        while(!q.isEmpty()){
            int currLevelSize  = q.size();

            for(int i=0; i<currLevelSize; i++){
                String node = q.poll();

                if(node.equals(endWord)){
                    return level+1;
                }
                
                List<String>neighbors = getNeighbors(node, set);
                for(String word : neighbors){
                    if(set.contains(word)){ // abi unvisited hai
                        q.add(word);
                        set.remove(word);// Remove word from set after adding to queue
                    }
                }
            }
            level++;
        }
         return 0;
         
    }
}
