class Solution {
    public int getLucky(String s, int k) {
      
        String res ="";
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            int num = ch-'a' + 1;
            res += num;
            
        }
       
        int sum = 0;
        while( k > 0){
            sum = 0;
            for(int i = 0; i<res.length(); i++){
                sum += res.charAt(i) - '0';
            }
            res = String.valueOf(sum);  // update res by sum
            k--;
        }
        
        return sum;
       
        
          
    }
}