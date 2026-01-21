import java.util.Arrays;

public class MinimumPlatforms {
  class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 1;
        int j = 0;
        int n = arr.length;
        
        int platform = 1;
        int maxplatform = 1;
        
        while(i < n && j < n){
            if(arr[i] <= dep[j]){ // abi train platform per hi hai
                platform++;
                i++;
               
            }else{
                platform--;
                j++;
            }
             maxplatform = Math.max(platform, maxplatform);
        }
        return maxplatform;
        
    }
}

}
