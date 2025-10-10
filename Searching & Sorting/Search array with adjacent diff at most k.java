
class Solution {
    public int findStepKeyIndex(int[] arr, int k, int x) {
        // code here
        
        int n = arr.length;
        for(int i = 1; i<n; i++){
           
            if(arr[i] == x){
                return i;
                
            }
        }
        return -1;
    }
}

class Solution {
    public int findStepKeyIndex(int[] arr, int k, int x) {
        int n = arr.length;
        int i = 0;

        while (i < n) {
            if (arr[i] == x) {
                return i;
            }

            // Jump based on difference and k
            int diff = Math.abs(arr[i] - x);
            int jump = Math.max(1, diff / k);

            i += jump;
        }

        return -1; // not found
    }
}
