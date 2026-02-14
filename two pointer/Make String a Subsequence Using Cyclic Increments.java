public class Make String a Subsequence Using Cyclic Increments {
  class Solution {
    // tc-min(n, m) , sc:O(1)
    public boolean canMakeSubsequence(String str1, String str2) {
        int idx1 = 0;
        int idx2 = 0;

        int n = str1.length();
        int m = str2.length();

        if(m > n) return false;
        // str2 me a hai to str1 me ya a ho ya to z ho
        // str2 me b hai to str1 me ya b ho ya to b-1 = a ho
        while(idx1 < n && idx2 < m){ // str1 = abc  str2 = ad
            if(str1.charAt(idx1) == str2.charAt(idx2)    // a == a or  z -/ --2nd itrn me b = d or c
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
