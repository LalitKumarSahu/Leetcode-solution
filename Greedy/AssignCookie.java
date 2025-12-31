import java.util.Arrays;

public class AssignCookie {
  // g[] (greed factor) → har child ko kitni minimum size ki cookie chahiye

// s[] (cookie size) → tumhare paas cookies ke size

// Rule:

// Har child ko maximum 1 cookie mil sakti hai

// Har cookie sirf 1 child ko di ja sakti hai

// Agar cookie size >= child greed → child satisfied 

class Solution {
    // Time: O(n log n) + O(m log m) + n (sorting)
    //  Space: O(1) (extra space nahi)
    public int maxChildren(int[] greed, int[] cookie) {
       Arrays.sort(greed);
        Arrays.sort(cookie);

        int i = 0;
        int j = 0;
        int count = 0;
        while(i < greed.length && j < cookie.length){
            if(cookie[j] >= greed[i]){
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return count;
        
    }
}

}
