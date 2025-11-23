import java.util.Arrays;
import java.util.HashMap;

public class twoSumProblem {
   // brute force
   public static boolean twoSum1(int arr[], int target) {
   int n = arr.length;
   for(int i = 0; i<n; i++){
    for(int j = 0; j<n; j++){
      if(i == j) continue;
      if(arr[i] + arr[j] == target) return true;
    }
   }
   return false;
 }

  // better using HashMap
public static boolean twoSum2(int arr[], int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
        int rem = target - arr[i];

        if (map.containsKey(rem)) {
            return true; // pair found
        }

        map.put(arr[i], i); // store after checking
    }

    return false;
 }

// optimal using sortiing + two pointer 
public static boolean twoSum(int[] arr, int target) {
    Arrays.sort(arr);  // Step 1: Sort the array

    int left = 0, right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target) return true;
        else if (sum < target) left++;
        else right--;
    }

    return false;
}



