  import java.util.*;
public class PreviousSmaller {


class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements >= current
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            // Set previous smaller
            nse[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // Push current element
            stack.push(arr[i]);
        }
        
        // Convert to ArrayList
        ArrayList<Integer> res = new ArrayList<>();
        for (int ns : nse) {
            res.add(ns);
        }
        return res;
    }
}
}
