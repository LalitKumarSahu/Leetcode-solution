class Solution {
    public int longestPalindrome(String s) {
       HashMap<Character, Integer>map = new HashMap<>();
       int oddCount = 0;
       int res = 0;

       for(char ch : s.toCharArray()){
         map.put(ch, map.getOrDefault(ch,0)+1);

         int currFreq = map.get(ch);
         if(currFreq % 2 != 0){
             oddCount++;
         }else{
            res+= 2;
            oddCount--;
           
          
         }
       }
       if(oddCount > 0){
        res += 1;
       }
       return res;
        
    }
}