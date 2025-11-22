public class LinearSearch {
  public static int linearSearch(int arr[], int k){

    int n = arr.length;
    for(int i= 0; i<n; i++){
      if(arr[i] == k){
        return i;
      }
    }
    return -1;
  }
}
