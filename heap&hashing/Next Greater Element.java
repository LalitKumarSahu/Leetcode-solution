import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        // traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // pop all smaller or equal elements
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // if stack is empty -> no greater element
            if (st.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(st.peek());
            }

            // push current element
            st.push(arr[i]);
        }

        // reverse because we filled from right to left
        Collections.reverse(ans);
        return ans;
    }
}
