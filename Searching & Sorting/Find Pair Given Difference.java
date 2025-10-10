
class Solution {
    public boolean findPair(int[] arr, int x) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int i = 0, j = n-1;
        while(i<j){
            if(arr[j] - arr[i] == x){
                return true;
            }else if(arr[j] - arr[i] < x){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}

import java.util.HashSet;

class Solution {
    public boolean findPair(int[] arr, int x) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : arr) {
            // Check if there exists a number such that difference is x
            if(set.contains(num + x) || set.contains(num - x)) {
                return true;
            }
            // Add current number to the set
            set.add(num);
        }
        
        return false;
    }
}

