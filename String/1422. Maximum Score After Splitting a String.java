class Solution {
    public int maxScore(String s) {
        int ones = 0;
        int n = s.length();

        for(int i = 0; i<n; i++){
            if(s.charAt(i) == '1') ones++;
        }
        int res = 0;
        int zero = 0;
        for(int i = 0; i<n-1; i++){
          if(s.charAt(i) == '0') zero++;
          else ones--;
          res = Math.max(res, ones + zero);
        }
     return res;
        
    }
}