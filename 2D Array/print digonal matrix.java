
// total no of diagonals = m+n-1

class Solution{
  public void printDigonal(int arr[][]){
    int m= arr.length;
    int n = arr[0].length

    for(int k = 0; k<=m-1; k++){
      int i = k;;
      int j = 0;
      while(i>=0 && j<n){
        System.out.print(arr[i][j]+" ");
        i = i-1;
        j = j+1;
      }
    }
    for(int k = 1; k<=n-1; k++){
      int i = m-1; // last row
      int j = k;
      while(i>=0 && j<=n-1){
        System.out.print(arr[i][j]+" ");
        i = i-1;
        j = j+1;
      }
    }
  }

  public static void main(String[] args) {
    
  }
}
