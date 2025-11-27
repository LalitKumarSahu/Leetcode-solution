import java.util.*;

public class MergeWithoutExtraSpace {
class Solution {
    // Time Complexity: O((n + m) * log(n + m))
    // Space Complexity: O(1)
    
    // arr1 she bade elm nikalenge last she
    // arr2 she smallest laynge start she
    public void mergeArrays(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        int i = 0, j = 0, k = n1 - 1;

        while (i <= k && j < n2) {
            if (a[i] > b[j]) {
                // Swap largest from 'a' with smallest from 'b'
                int temp = a[k];
                a[k] = b[j];
                b[j] = temp;
                k--;
                j++;
            } else {
                i++;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }
}

}
