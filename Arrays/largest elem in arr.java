public class largest elem in arr {

  class Solution {
      // brute force
     public static int largest1(int[] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        return arr[n-1];
       
    }
    // optimal
    public static int largest2(int[] arr) {
        // code here
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        
        for(int i = 0; i<n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}


}
