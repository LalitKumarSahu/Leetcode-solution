public class Number of Substrings Containing All Three Characters {
  class Solution {
    public int numberOfSubstrings(String s) {
        int freq[]  = new int[3];
        int count= 0;
        int currCount = 0;
        int left = 0;

        int n = s.length();

        for(int right = 0; right < n; right++){
             
             // expanding phase
            char ch = s.charAt(right);
            freq[ch - 'a']++;
            if(freq[ch - 'a'] == 1){
                currCount++;
            }

            // shrinking
            while(currCount == 3){
                count += (n - right);
                char ch2 = s.charAt(left);
                freq[ch2 - 'a']--;
                if(freq[ch2 - 'a'] == 0){
                    currCount--;
                }
                left++;
            }
        }
        return count;
    }
}
}
