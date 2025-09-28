class Solution {
    // tc-O(N)
    public int countSeniors(String[] details) {
        int count = 0;

        // travers the details array
        for(String detail : details){ //O(N)
            int a = detail.charAt(11)-'0';
            int b = detail.charAt(12)-'0';

            int ageVal =   a*10 + b;

            if(ageVal > 60){
              count++;
            }
        }
        return count;
        
    }
}
