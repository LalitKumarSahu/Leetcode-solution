// ek aise string return karna hai jisme dono str ka sub seq ho
//eg str1 = "abac", str2 = "cab"
// cabac isme abac and cab both are present

// soln agr str1 and str2 ko add kar de to jo common char hai vo repeat ho jayega
//cab + abac = cababac

// agr isme lcs find kar ke total len se minus kar de to answer aa jayega
// lcs = ab = 2(len) total = 7, 7-2 = 5(cabac)

// ye btyega length of sortest common super seq
// class Solution {
//     public String shortestCommonSupersequence(String str1, String str2) {
//         int n = str1.length();
//         int m = str2.length();

//         int ans = longestCommonSubsequence(str1, str2);
//         return n + m - ans;
//     }
 
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
        
//         int prev[] = new int[m+1];
//         prev[0] = 0;
//         for(int i = 1; i<n+1; i++){
//             int curr[] = new int[m+1];
//             curr[0] = 0;
//             for(int j =1; j<m+1; j++){
//                 if(text1.charAt(i-1) == text2.charAt(j-1)){
//                 curr[j] =  1 + prev[j-1];//rec(i-1, j-1, text1, text2, dp);
                
//                 }else{
//                     int case1 = prev[j];  //rec(i-1, j, text1, text2, dp);
//                     int case2 = curr[j-1];  //rec(i, j-1, text1, text2, dp);
//                     curr[j] =  Math.max(case1, case2);
                
//                 }
//             }
//             prev = curr;
//         }
//         return prev[m];

//     }
 

// }

// return sortest substring jinme str1 and str2 dono ka subsequence
class Solution {
     // tc-N+M
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = longestCommonSubsequence(str1, str2);
        int n = dp.length;
        int m = dp[0].length;
        int i=n-1;
        int j=m-1;

        StringBuilder sb = new StringBuilder();
        while( i>0 && j>0){ // koi ek end ho jaye fir baki elm ko print karna
         if(str1.charAt(i-1) == str2.charAt(j-1)){ // digonal sift
            sb.append(str1.charAt(i-1));
            i--;
            j--;

         }else if(dp[i-1][j] > dp[i][j-1]){  //  left  & top me she max kon hai,  max pe sift
            sb.append(str1.charAt(i-1)); // print row vala fir delete mar denge (moving up)
             i--;

         }else{
             sb.append(str2.charAt(j-1)); // print col vala fir delete mar denge (moving left)
             j--;
         }
        }

        // bache hue ko pura print karna
         while(i > 0){
            sb.append(str1.charAt(i-1)); // print row vala fir delete mar denge (moving up)
             i--;
         }
         while(j > 0){
            sb.append(str2.charAt(j-1)); // print row vala fir delete mar denge (moving up)
             j--;
         }
         return sb.reverse().toString();
    
    }
     // table me matching , aur not matching dono ko print karana hai - shortestCommonSupersequence
     // lcs me keval matching ko hi print karte the
    
    // tc-N*M
    public int[][] longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n+1][m+1];

        // Base case ,i=0 || j=0
        dp[0][0] = 0;
        for(int i=1; i<n+1; i++){
        for(int j=1; j<m+1; j++){

            // if, in match both text 
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                dp[i][j] =  1 + dp[i-1][j-1];

            }else{ // not match
                    int case1 =  dp[i][j-1] ;
                    int case2 =  dp[i-1][j];
                    dp[i][j] =  Math.max(case1, case2);
                    
            }
            }
        }
        return dp;
        

    }

}
