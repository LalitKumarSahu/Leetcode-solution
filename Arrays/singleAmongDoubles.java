import java.util.HashMap;

public class singleAmongDoubles {
  // User function Template for Java

class Sol {
    // m-1 brute force
  public static int search1(int n, int arr[]) {

    for (int i = 0; i < n; i++) {
        int num = arr[i];
        int count = 0;

        // count frequency of arr[i]
        for (int j = 0; j < n; j++) {
            if (arr[j] == num) {
                count++;
            }
        }

        // if element appears only once → return it
        if (count == 1) {
            return num;
        }
    }

    return -1;
}

    // m-2 better soln using Map or hashArr - max size
    public static int search2(int n, int arr[]) {
      HashMap<Integer,Integer>map = new HashMap<>();
       
      for(int num : arr){
          map.put(num , map.getOrDefault(num , 0 ) + 1);
      }
      for(int key : map.keySet()){
          int val = map.get(key);
          if(val == 1){
              return key;
          }
      }
      return -1;
        
    }
    
    // m-3 optimal by using xor
    public static int search3(int n, int arr[]) {
         int xor = 0;
         for (int i = 0; i < n; i++) {
              xor ^= arr[i];
         }
         return xor;
       
  }
}
  
}
