public class LeftRotateArrayByDPlaces {

    static class Solution {
        public static int[] leftRotate(int arr[], int d) {
            int n = arr.length;
            
            d = d % n;          // Important: handle cases when d > n
            int temp[] = new int[d];

            // Step 1: Store first d elements in temp
            for (int i = 0; i < d; i++) {
                temp[i] = arr[i];
            }

            // Step 2: Shift the remaining elements left
            for (int i = d; i < n; i++) {
                arr[i - d] = arr[i];
            }

            // Step 3: Put temp elements at the end
            int j = 0;
            for (int i = n - d; i < n; i++) {
                arr[i] = temp[j];
                j++;
            }

            return arr;
        }
    }
}
