public class Longest Consecutive Subsequence {
  class Solution {
    // Brute force tc :O(N^2)

    public int longestConsecutive(int[] arr) {

        if(arr.length == 0) return 0;

        int longest = 1;
        int n = arr.length;

        for(int i = 0; i < n; i++){
            int x = arr[i];
            int count = 1;

            while(linearS(arr, x + 1)){
                x++;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public boolean linearS(int[] arr, int num){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num) return true;
        }
        return false;
    }
    
    // m-2 better soln, sorting + prev Small
     public int longestConsecutive(int[] arr) {

        

        int longest = 1;
        int n = arr.length;
        if(n == 0) return 0;
        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] - 1 == lastSmaller){
                count++;
                lastSmaller = arr[i];
            }else if(lastSmaller != arr[i]){
                count = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, count);

        }

        return longest;
    }
    
    //m-3 optimal soln using set
    public int longestConsecutive(int[] arr) {
    
      HashSet<Integer> set = new HashSet<>();

        // Step 1: put all elements in set
        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: find starting points
        for (int num : set) {

            // check if it is starting of sequence
            if (!set.contains(num - 1)) {

                int currNum = num;
                int count = 1;

                // Step 3: check consecutive
                while (set.contains(currNum + 1)) {
                    currNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
    
    
}

  
}
