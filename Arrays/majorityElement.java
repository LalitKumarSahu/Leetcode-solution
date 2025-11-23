import java.util.HashMap;

public class majorityElement {
  // brute force
class Solution {
    int majorityElement(int arr[]) {
      int n = arr.length;
      for(int i = 0; i<n; i++){
          int count = 0;
          for(int j = 0; j<n; j++){
              if(arr[i] == arr[j]){
                  count++;
              }
          }
          if(count > n/2){
              return arr[i];
          }
      }
      return -1;
        
    }
}

// m-2
class Solution {
    int majorityElement(int arr[]) {
        // code here
        HashMap<Integer,Integer>map = new HashMap<>();
        
        int mjElm = arr.length/2;
        
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > mjElm){
                return key;
            }
        }
        return -1;
        
    }
}


// m-3 moores's voting algo
class Solution {
    int majorityElement(int[] arr) {
        int candidate = -1;
        int count = 0;

        // 1. Find a candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // 2. Verify candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }

        if (count > arr.length / 2) return candidate;
        return -1;
    }
}

  
}
