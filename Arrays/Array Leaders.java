public class Array Leaders {
  class Solution {
    // m-1 Brute force
    static ArrayList<Integer> leaders(int arr[]) {

        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;

        for(int i = 0; i < n; i++){
            boolean isLeader = true;

            // check right side
            for(int j = i+1; j < n; j++){
                if(arr[j] > arr[i]){
                    isLeader = false;
                    break;
                }
            }

            if(isLeader){
                ans.add(arr[i]);
            }
        }

        return ans;
    }
    
    // m-2 optimal
      static ArrayList<Integer> leaders(int arr[]) {

        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = n-1; i>= 0; i--){
           if(arr[i] >= max){
               ans.add(0,arr[i]);
               max = arr[i];
           }
        }
        return ans;
    }
}

}
