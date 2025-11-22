public class LeftRotateArrayByOnePlaces {
  
  class Solution{
    public static int[] leftRotateAnArrayByOnePlace(int arr[]){

      int n = arr.length;
      int temp = arr[0];
      for(int i = 1; i<n; i++){
        arr[i-1] = arr[i];
      }
      arr[n-1] = temp;

      return arr;
    }
    
  }
}
