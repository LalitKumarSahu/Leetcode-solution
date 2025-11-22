public class missingInArray {
  class Solution {
    
    // m-1 Brute force  tc O(n^2), sc:O(1)
      int missingNum1(int arr[]) {
        int n = arr.length + 1;
        
        for(int i = 1; i<= n; i++){
            boolean isFound = false;
            for(int j = 0; j<arr.length; j++){
                if(arr[j] == i){
                    isFound = true;
                    break;
                }
            }
            // missing i in arr
            if(!isFound){
                return i;
            }
            
        }
        return -1;
      }    

       
      // m - better method  tc :o(2N), sc :O(N)
      
    int missingNum2(int arr[]) {
        int n = arr.length + 1;
        int hashArr[] = new int[n + 1];  // n numbers ke liye
        
        // mark present numbers
        for (int num : arr) {
            hashArr[num] = 1;
        }
    
        // check which number is missing
        for (int i = 1; i <= n; i++) {
            if (hashArr[i] == 0) {
                return i;
            }
        }
    
        return -1;
}
       
    // tc : O(n), sc:O(1)
    int missingNum3(int arr[]) {
        int sum = 0;
        int n = arr.length + 1; // total numbers including missing one
        
        for (int num : arr) {
            sum += num;
        }

        int expectedSum = n * (n + 1) / 2;
        return expectedSum - sum;
    }
      //most optimal  tc : O(n), sc:O(1)
   int missingNum4(int arr[]) {

    int n = arr.length + 1;  // numbers from 1 to n

    int xor1 = 0;
    for (int i = 1; i <= n; i++) {  
        xor1 ^= i;
    }

    int xor2 = 0;
    for (int i = 0; i < arr.length; i++) {
        xor2 ^= arr[i];
    }

    return xor1 ^ xor2;
}
}

  
}
