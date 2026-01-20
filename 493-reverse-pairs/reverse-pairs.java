// m-1 Brute force
// class Solution {
//     public int reversePairs(int[] nums) {
//         int count = 0;
//         int n = nums.length;

//         for(int i = 0; i<n; i++){
//             for(int j = i+1; j<n; j++){
//             //2 * nums[j] overflow kar sakta hai, isliye long use karna zaroori hai.
//                 if((long)nums[i] > 2L * nums[j]){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

// m-2 merge sort
// pehle divide the arr into left half and right half
// nums[i] > 2 * nums[j] false hai to i++ aur j se pehle tak elm inc the count
// nums[i] > 2 * nums[j] true hai to j++ hoga
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;

        int count = 0;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        // 🔥 count reverse pairs
        count += countPairs(nums, low, mid, high);

        // merge sorted halves
        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if ((long) nums[i] > 2L * nums[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= high) temp[k++] = nums[j++];

        for (int x = 0; x < temp.length; x++) {
            nums[low + x] = temp[x];
        }
    }
}
