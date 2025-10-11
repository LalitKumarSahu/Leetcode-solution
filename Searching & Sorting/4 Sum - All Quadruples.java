public class 4 Sum - All Quadruples {
  import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution1{
    static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;

        // Generating all possible quadruplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            ArrayList<Integer> curr = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                            
                            // Sort to avoid duplicates in different order
                            Collections.sort(curr);
                            
                            // Check for uniqueness
                            if (!res.contains(curr)) {
                                res.add(curr);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}

// m-2 using 3 loop
class Solution2 {
    static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        HashSet<ArrayList<Integer>> res = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                HashSet<Integer> set = new HashSet<>();

                for (int k = j + 1; k < n; k++) {

                    long sum = (long) arr[i] + arr[j] + arr[k];
                    long fourth = target - sum;  // ✅ fixed formula

                    if (set.contains((int) fourth)) {
                        ArrayList<Integer> curr = new ArrayList<>(
                            Arrays.asList(arr[i], arr[j], arr[k], (int) fourth)
                        );
                        Collections.sort(curr);  // to handle duplicates like [1,2,3,4] vs [3,4,1,2]
                        res.add(curr);
                    }

                    set.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(res);
    }
}

//m-4 optimal soln
import java.util.*;

class Solution3 {
    static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Sort array to apply two-pointer and skip duplicates
        Arrays.sort(arr);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for i
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for j
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];

                    if (sum == target) {
                        res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l])));
                        k++;
                        l--;

                        // Skip duplicates for k and l
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return res;
    }
}



  
}
