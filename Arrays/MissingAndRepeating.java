import java.util.ArrayList;
import java.util.HashMap;

public class MissingAndRepeating {
  class Solution {
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

}
