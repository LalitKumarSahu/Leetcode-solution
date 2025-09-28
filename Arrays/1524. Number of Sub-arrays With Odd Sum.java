class Solution {
    // brute force
    public int numOfSubarrays(int[] arr) {
    int n = arr.length;
    int count = 0;

     for(int i = 0; i<n; i++){ // [1,3,5] i = 1, then 3 , then 5
        int sum = 0;
        for(int j = i; j<n; j++){ // 1 to 5,   3 to 5 , 5
           sum += arr[j];
           if(sum % 2 != 0){
            count++;
           } 

        }
     }
     return count;
        
    }
}

//m-2
class Solution {
    public int numOfSubarrays(int[] arr) {
        int Mod = 1000000007;
        int evenC = 1;  // prefix sum 0 ko even count kar rahe
        int oddC = 0;
        int prefix = 0;
        int res = 0;

        for(int num : arr){
            prefix += num;
            if(prefix % 2 == 0){
                res += oddC;   // agar prefix even hai, to odd subarray banega odd prefix ke saath
                evenC++;
            }else{
                res += evenC;  // agar prefix odd hai, to odd subarray banega even prefix ke saath
                oddC++;
            }
            res = res % Mod;
        }
        return res;
    }
}

