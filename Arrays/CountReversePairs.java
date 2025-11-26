public class CountReversePairs {
  public int countRevPairs(int[] arr) {
      int n = arr.length;
      int count = 0;
      for(int i = 0; i<n; i++){
          
          for(int j = i+1; j<n; j++){
              
              if(arr[i] > 2 * arr[j]){
                  count++;
              }
          }
      }
      return count;
      
        
    }
}
