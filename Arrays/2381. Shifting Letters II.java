class Solution {
    //tc:O(M+N) by using swip line algo
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int arr[] = new int[n];

        for(int []shift : shifts){

            if(shift[2] == 1){ // forward 
              arr[shift[0]]++;
              if(shift[1]+ 1 < n){
                arr[shift[1]+ 1]--;
              }

            }else{  // backward
              arr[shift[0]]--;
              if(shift[1]+ 1 < n){
                arr[shift[1]+ 1]++;
              }
            }
        }
        StringBuilder res = new StringBuilder(s);
        int sum = 0;

        for(int i =0; i<n; i++){
            sum = (sum + arr[i])%26;  // sum = 30 , a => 30%26 = 4, a + 4 = e
            if(sum < 0) sum += 26; // b and sum = -3, add 26 sum = 23 b + 23 = y

            char shiftedChar = (char)('a' + ((s.charAt(i)-'a' + sum)%26));
            res.setCharAt(i, shiftedChar);
        }
        return res.toString();
        
    }
}