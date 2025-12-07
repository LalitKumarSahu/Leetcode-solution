public class 2nd largest {

  // brute force 
  public static int secLargest(int arr[]){
    Arrays.sort(arr);
    int n = arr.length;

    for(i = n-2; i>= 0; i--){
      if(arr[n-1] != arr[i]){
        return arr[i]; // 2nd largest hai
      }
    }
  }

  // m-2 better
   public static int secLargest(int arr[]){
      int n = arr.length;
      int fisrtLargest = Integer.MIN_VALUE;

      for(int i = 0; i<n; i++){
        if(arr[i] > fisrtLargest ){
          fisrtLargest = arr[i];
        }
      }
       int secLargest = -1;
      for(int i= 0; i<n; i++){
         if(arr[i] > secLargest && arr[i] !=  fisrtLargest ){
          secLargest = arr[i];
         }
      }
      return secLargest;

  }

 
  // m-3 optimal
   public static int secLargest(int arr[]){
      int n = arr.length;
      int fisrtLargest = arr[0];
      int secLargest = -1;

      for(int i = 1; i < n; i++){
        if(arr[i] > fisrtLargest ){
          secLargest = fisrtLargest;
          fisrtLargest = arr[i];
        }else if(arr[i] >  secLargest && arr[i] != fisrtLargest ){
          secLargest = arr[i];
        }
      }
        return (secLargest == Integer.MIN_VALUE) ? -1 : secLargest;

  }


  
}
