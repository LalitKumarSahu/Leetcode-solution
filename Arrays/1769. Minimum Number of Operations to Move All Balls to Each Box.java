class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int left[] = new int[n];
        int right[] = new int[n];
        int res[] = new int[n];

        left[0] = 0;
        right[n-1] = 0;
        // '1'-'0' = 1
        // '0'-'0' = 0
        
        int count = boxes.charAt(0)-'0';
        // left

        for(int i = 1; i<n; i++){
            left[i] = left[i-1] + count; // prevAns + totalBalls
            count += boxes.charAt(i)-'0';
        }

        // right
        count = boxes.charAt(n-1)-'0';
        for(int i = n-2; i>=0; i--){
            right[i] = right[i+1] + count; // nextSum + totalCount
            count += boxes.charAt(i)-'0';
        }

        for(int i = 0; i<n; i++){
            res[i] = left[i] + right[i];
        }
        return res;
   
    }
    

     public int[] minOperations2(String boxes) {
        int n = boxes.length();

        int left[] = new int[n];

        left[0] = 0;
       
        // '1'-'0' = 1
        // '0'-'0' = 0
        
        int count = boxes.charAt(0)-'0';
        // left

        for(int i = 1; i<n; i++){
            left[i] = left[i-1] + count; // prevAns + totalBalls
            count += boxes.charAt(i)-'0';
        }

        // right
        count = boxes.charAt(n-1)-'0';
        int prevRight = 0;
        int currRight = 0;
        for(int i = n-2; i>=0; i--){
            currRight = prevRight + count; // nextSum + totalCount
            prevRight = currRight;
            left[i]= left[i] + currRight;
            count += boxes.charAt(i)-'0';
        }
       return left;
        
   
    }

}
