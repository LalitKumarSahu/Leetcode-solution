public class makeStringASubsequenceUsingCyclicIncrements {
  class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int idx1 = 0;
        int idx2 = 0;

        int n = str1.length();
        int m = str2.length();
         
         //conversion can never possible
        if(m > n) return false;
         
         // basicly str2 ke char ya to complete match krega ya to str2 ka char -1 match krega str1 me
        while(idx1 < n && idx2 < m){ 
            if(str1.charAt(idx1) == str2.charAt(idx2)    
            || (str1.charAt(idx1) == str2.charAt(idx2)-1)
            || (str1.charAt(idx1) == 'z' && str2.charAt(idx2) == 'a')
            ){
                idx2++;
            }
            idx1++;
        }
        return (idx2 == m);
    }
}
}
