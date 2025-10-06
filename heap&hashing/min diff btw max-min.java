import java.sql.Array;

class Solution{

  public static minMaxDiff(int arr[], int m){
     int n = arr.length;

     if(m == 0 || n == 0) return 0;
      if(n < m) return -1;

    Array.sort(arr);
   
    int minDiff = Integer.MAX_VALUE;
    for(int i = 0; i+m-1<n; i++){
     minDiff = Math.min(minDiff, arr[i+m-1]-arr[i]);
    }
    return minDiff;
  }
  

  public static void main(String[] args) {
    

  }
}
