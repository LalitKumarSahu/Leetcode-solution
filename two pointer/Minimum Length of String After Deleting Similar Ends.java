public class Minimum Length of String After Deleting Similar Ends {
  // first se pick karnge char ko agr same hai to append karte jaynge
// last me bhi same yhi karnge same hai to append

// remove kar denge 

class Solution {
    public int minimumLength(String s) {
        int n = s.length();

        int left = 0;
        int right = n-1;

        while(left < right && s.charAt(left) == s.charAt(right)){

            char ch = s.charAt(left);
            
            // delete - perfix jitne bhi same hai unhe delete left ke
            while(left <= right && s.charAt(left) == ch){
                left++;
            }
            // delete - suffix jitne bhi same hai unhe delete right ke
             while(left <= right && s.charAt(right) == ch){
                right--;
            }

        }
         return right -left + 1;
    }
}
}
