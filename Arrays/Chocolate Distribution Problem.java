// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        
        if(m == 0 || arr.size() == 0) return 0;
      
      Collections.sort(arr);
      
      int n = arr.size();
      int minDiff = Integer.MAX_VALUE;
      for(int i = 0; i<= n-m; i++){
          int diff = arr.get(i + m -1) - arr.get(i); // last - first
          minDiff = Math.min(minDiff, diff);
      
      }
      return minDiff;
    }
}