public class LongestPalindromicSubSeq {
  // Longest Palindromic Subsequence 
// given string and ush string ka rev ka lcs
class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        return longestCommonSubsequence(s, sb.reverse().toString());
    }
//---------------------->
    // lcs = ac
    // str1 = abc
    //str2 = ace
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
