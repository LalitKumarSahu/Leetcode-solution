class Solution {
     public List<String> getNeighbors(String word, HashSet<String> set) {
        List<String> neighbors = new ArrayList<>();
        
        for (int i = 0; i < word.length(); i++) { // 3 - 0,1,2
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i)) { // same char ho to skip
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

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
         HashSet<String> set = new HashSet<>(wordList);
         List<List<String>> res = new ArrayList<>();
        if (!set.contains(endWord)) {
            return res;
        }
        
        List<String>dummy = new ArrayList<>();
        dummy.add(beginWord);
        Queue<List<String>>q = new LinkedList<>();
        q.add(dummy);

        // If beginWord is already present in wordList(set), then remove it
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        
        int level = 1; // Level starts from 1 since we include the beginWord
        int resLevel = -1;
        // BFS
        while (!q.isEmpty()) {
            HashSet<String>useWords = new HashSet<>();
            int currLevelSize = q.size();
            for (int i = 0; i < currLevelSize; i++) {
                List<String> nodeList = q.remove();  // puri list ko remove krenge
                String node = nodeList.get(nodeList.size()-1); //  ush list ka last word
                if (node.equals(endWord)) {
                    resLevel = level;
                    res.add(nodeList);
                    
                }
                List<String> neighbors = getNeighbors(node, set);
                for (String word : neighbors) {
                   if(set.contains(word)){ // bat-> cat,bot // bat-> bot
                    nodeList.add(word); // [bat,cat] // [bat, bot]
                    q.add(new ArrayList<>(nodeList));// [bat,cat] //[bat, bot]
                    nodeList.remove(word);// [bat->bot] // [bot]
                    useWords.add(word);// cat // bot
                   }
                }
            }

            for(String visited : useWords){
                set.remove(visited);
            }
            if(level == resLevel){
                break;
            }
            level++;
        }
        return res;
    }
}


