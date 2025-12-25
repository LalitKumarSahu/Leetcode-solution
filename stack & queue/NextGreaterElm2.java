import java.util.ArrayList;

public class NextGreaterElm2 {
  class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        
        for (int i = 0; i < n; i++) {
            nge[i] = -1; // Initialize with -1
            
            // Check next n-1 elements (circularly)
            for (int j = 1; j < n; j++) {
                int idx = (i + j) % n; // Circular index
                
                if (arr[idx] > arr[i]) {
                    nge[i] = arr[idx];
                    break; // Found first greater element
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int ng : nge) {
            res.add(ng);
        }
        return res;
     }
    }
}

// m-2 optimal soln
public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> s = new Stack<>();
        
        // Correct: i-- not i++ for descending loop
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            
            while (!s.isEmpty() && s.peek() <= arr[idx]) {
                s.pop();
            }
            
            if (i < n) {
               
                nge[idx] = s.isEmpty() ? -1 : s.peek();
            }
            
            s.push(arr[idx]);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int ng : nge) {
            res.add(ng);
        }
        return res;
    }
   
   
