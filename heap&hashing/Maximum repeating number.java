// User function Template for Java

class Solution {
    int maxRepeating(int k, int[] arr) {
      
  
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num ,  0) + 1);
        }
        int elm = Integer.MAX_VALUE;
        int freq = Integer.MIN_VALUE;
        for(int key : map.keySet()){
            int count = map.get(key);
            if(count > freq || (count == freq && key < elm)){
                elm = key;
                freq = count;
            }
        }
        return elm;
    }
}