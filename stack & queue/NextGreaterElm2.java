import java.util.ArrayList;
import java.util.Stack;

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
// ham imazine karenge given arr = {1,2,3,4} --copy-> (1,2,3,4,1,2,3,4)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] nextGreater = new int[n];
        
        // Initialize nextGreater array with -1
        for (int i = 0; i < n; i++) {
            nextGreater[i] = -1;
        }

        // Traverse the array twice to simulate circular behavior
        for (int i = 2 * n - 1; i >= 0; i--) {
            // step 1- while
            while (!s.isEmpty() && nums[s.peek()] <= nums[i % n]) {
                s.pop();
            }
            // step -2 if stack is not empty
            if (i < n) {
                if (!s.isEmpty()) {
                    nextGreater[i] = nums[s.peek()];
                }
            }

            // step 3- push the current index in stack
            s.push(i % n);
        }
        
        return nextGreater;
    }
}

