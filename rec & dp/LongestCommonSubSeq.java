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
//m-2 top down with memoization
class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }
        return rec(n-1, m-1, text1, text2,dp);

    }
    public int rec(int i , int j,String text1, String text2, int dp[][]){
        // base case
        if( i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
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
}
