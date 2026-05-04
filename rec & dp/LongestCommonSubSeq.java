import java.util.Arrays;

public class LongestCommonSubSeq {
  class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return rec(n-1, m-1, text1, text2);

    }
    public int rec(int i , int j,String text1, String text2){
        // base case
        if( i < 0 || j < 0){
            return 0;
        }
        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + rec(i-1, j-1, text1, text2);
        }else{
            int case1 = rec(i-1, j, text1, text2);
            int case2 = rec(i, j-1, text1, text2);
            return Math.max(case1, case2);
        }

    }
}
class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }
        return rec(n, m, text1, text2,dp);

    }
    public int rec(int i , int j,String text1, String text2, int dp[][]){
        // base case
        if( i == 0 || j == 0){

            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(text1.charAt(i-1) == text2.charAt(j-1)){
            dp[i][j] =  1 + rec(i-1, j-1, text1, text2, dp);
            return dp[i][j];
        }else{
            int case1 = rec(i-1, j, text1, text2, dp);
            int case2 = rec(i, j-1, text1, text2, dp);
            dp[i][j] =  Math.max(case1, case2);
            return dp[i][j];
        }

    }
}
// m-3 bottom up
class Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        dp[0][0] = 0;
        for(int i = 1; i<n+1; i++){
            for(int j =1; j<m+1; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                dp[i][j] =  1 + dp[i-1][j-1];//rec(i-1, j-1, text1, text2, dp);
                
            }else{
                int case1 = dp[i-1][j];  //rec(i-1, j, text1, text2, dp);
                int case2 =dp[i][j-1];  //rec(i, j-1, text1, text2, dp);
                dp[i][j] =  Math.max(case1, case2);
                
            }
            }
        }
        return dp[n][m];

    }
    

    }

    // m-4 space optimization
    class Solution4 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int prev[] = new int[m+1];
        prev[0] = 0;
        for(int i = 1; i<n+1; i++){
            int curr[] = new int[m+1];
            curr[0] = 0;
            for(int j =1; j<m+1; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                curr[j] =  1 + prev[j-1];//rec(i-1, j-1, text1, text2, dp);
                
                }else{
                    int case1 = prev[j];  //rec(i-1, j, text1, text2, dp);
                    int case2 = curr[j-1];  //rec(i, j-1, text1, text2, dp);
                    curr[j] =  Math.max(case1, case2);
                
                }
            }
            prev = curr;
        }
        return prev[m];

    }
 
}
}

