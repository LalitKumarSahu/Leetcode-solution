class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {

        HashMap<String, Integer>map = new HashMap<>();
        // N+M
        for(String word : s1.split(" ")){ // N
          map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
          for(String word : s2.split(" ")){ // M
          map.put(word, map.getOrDefault(word, 0) + 1);
        }

        ArrayList<String>list = new ArrayList<>();
        // for(String key : map.keySet()){
        //     if(map.get(key) == 1){ // if freq is equal to 1 then add into list
        //         list.add((key));
        //     }
        // }
        //---------OR---------->
            for(Map.Entry<String, Integer>entry : map.entrySet()){ //N+M
            if(entry.getValue() == 1){ // if freq is equal to 1 then add into list
                list.add(entry.getKey());
            }
        }
        // convert ArraList of String into string[] arr
        String res[] = new String[list.size()]; // K
        list.toArray(res);

        return res;
    }
}