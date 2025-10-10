// User function Template for Java
import java.util.*;

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Set use kar rahe taaki duplicate count na ho
        for (int num : new HashSet<>(arr1)) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : new HashSet<>(arr2)) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : new HashSet<>(arr3)) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == 3) { // Teeno arrays me common
                ans.add(key);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}

// m-2 optimization
class Solution {
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        int i = 0, j = 0, k = 0;
        List<Integer> ans = new ArrayList<>();
        int n1 = arr1.size(), n2 = arr2.size(), n3 = arr3.size();
        Integer prev = null; // to handle duplicates

        while (i < n1 && j < n2 && k < n3) {
            int a = arr1.get(i), b = arr2.get(j), c = arr3.get(k);

            if (a == b && b == c) {
                // avoid duplicates
                if (prev == null || prev != a) {
                    ans.add(a);
                    prev = a;
                }
                i++; j++; k++;
            } else if (a < b) {
                i++;
            } else if (b < c) {
                j++;
            } else {
                k++;
            }
        }
        return ans;
    }
}
