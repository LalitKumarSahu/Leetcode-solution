public class MoveAllZeroToEnd {
 class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int temp[] = new int[n];
        int index = 0;

        // Step 1: copy non-zero elements to temp
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[index] = arr[i];
                index++;
            }
        }

        // Step 2: remaining positions fill with 0
        while (index < n) {
            temp[index] = 0;
            index++;
        }

        // Step 3: copy temp back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}


// m-2 : optimal approach
    void pushZerosToEnd(int[] arr) {
        
        int j= 0;
        int n = arr.length;
        
        for(int i = 0; i<n; i++){
            if(arr[i] != 0){
                arr[j] = arr[i];
                j++;
            }
            
        }
        while(j < n){
            arr[j] = 0;
            j++;
        }
   
        
    }
}
  

