import java.util.ArrayList;
import java.util.HashMap;

public class MissingAndRepeating {
  class Solution {

    // Brute -> for 1 to n iterate arr and check appear 2 times repeating number appear 0 times missing no
     
    // better Approach
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        int sum = 0;
        int repeating = -1;
        
        // Count frequency and calculate sum
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            sum += num;
        }
        
        // Find repeating number
        for (int key : map.keySet()) {
            if (map.get(key) == 2) {
                repeating = key;
                list.add(repeating);  // ✔ Add repeating
                break;
            }
        }
        
        int nthSum = n * (n + 1) / 2;
        
        // Correct missing formula
        int missing = nthSum - (sum - repeating);
        
        list.add(missing);  // ✔ Add missing
        
        return list;
    }
}

// optimal
ArrayList<Integer> findTwoElement(int arr[]) {

    ArrayList<Integer> list = new ArrayList<>();
    int n = arr.length;

    // Sum of 1..n  (use long)
    long sn = (long) n * (n + 1) / 2;

    // Sum of squares of 1..n (use long)
    long s2n = (long) n * (n + 1) * (2L * n + 1) / 6L;

    long s = 0L, s2 = 0L;

    // Calculate actual sum and square sum
    for (int i = 0; i < n; i++) {
        s += (long) arr[i];
        s2 += (long) arr[i] * (long) arr[i];
    }

    long sum1 = s - sn;       // x - y
    long sum2 = s2 - s2n;     // x^2 - y^2

    sum2 = sum2 / sum1;       // (x + y)

    long repeating = (sum1 + sum2) / 2;  // x
    long missing = repeating - sum1;     // y

    list.add((int) repeating);
    list.add((int) missing);

    return list;
}


}
