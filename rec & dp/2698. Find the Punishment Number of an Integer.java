class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i = 1; i<=n; i++){
            String i2 = Integer.toString(i * i);
            if(isPartitioned(0, i2, i, 0)){ // idx , i*i, i
                res += (i * i);
            }
        }
        return res;
        
    }
    public boolean isPartitioned(int idx, String i2, int i, int currSum){
       int n = i2.length();

       // base case
       if(idx == n){
         return(currSum == i);
       }
        if(currSum > i){
            return false;
        }
       for(int j = idx; j<n; j++){
        int val = Integer.parseInt(i2.substring(idx, j+1));
        if(isPartitioned(j+1, i2, i,  currSum + val)){
            return true;
        }
       }
       return false;


    }
}

// by using dp
class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i = 1; i<=n; i++){
            String i2 = Integer.toString(i * i);
            int len = i2.length();
            int dp[][] = new int[len][i+1];
            for(int k = 0; k<len; k++){
                Arrays.fill(dp[k], -1);
            }
            if(isPartitioned(0, i2, i, 0, dp)){ // idx , i*i, i
                res += (i * i);
            }
        }
        return res;
        
    }
    public boolean isPartitioned(int idx, String i2, int i, int currSum, int dp[][]){
       int n = i2.length();

       // base case
       if(idx == n){
         return(currSum == i);
       }
        if(currSum > i){
            return false;
        }
        if(dp[idx][currSum] != -1){
          return (dp[idx][currSum] == 1);
        }
       for(int j = idx; j<n; j++){
        int val = Integer.parseInt(i2.substring(idx, j+1));
        if(isPartitioned(j+1, i2, i,  currSum + val, dp)){
            dp[idx][currSum] = 1; // true
            return true;
        }
       }
       dp[idx][currSum] = 0; // false
       return false;


    }
}