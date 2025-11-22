import java.util.ArrayList;
import java.util.HashSet;

public class intersectionOfTwoSortedArray{
   
  class Solution {
     // brute force tc : O(N * M), sc : O(1)
     public ArrayList<Integer> intersection1(int arr1[], int arr2[]) {
        
        int n = arr1.length;
        int m = arr2.length;
       
        ArrayList<Integer>res = new ArrayList<>();
       for(int i= 0; i<n; i++){
           for(int j = 0; j<m; j++){
               
               if(arr1[i] == arr2[j]){
                   if(!res.contains(arr1[i])){
                       res.add(arr1[i]);
                   }
                   break;
               }
           }
       }
        return res;
        
      
    }
    // m-2 tc : O(n + m), sc : O(1) (except res)
    public ArrayList<Integer> intersection2(int arr1[], int arr2[]) {
        // code here
        int n = arr1.length;
        int m = arr2.length;
        
        int i = 0; int j = 0;
        ArrayList<Integer>res = new ArrayList<>();
        while(i < n && j < m){
          if(arr1[i] == arr2[j]){
              // avoid duplicate
                if(res.size() == 0 || res.get(res.size() - 1) != arr1[i]){
                res.add(arr1[i]);
            }
            i++;j++;
          }else if(arr1[i] < arr2[j]){
              i++;
          }else{
              j++;
          }
            
        }
        return res;
    }
    
    // m-3 by using Hashset
     public ArrayList<Integer> intersection3(int arr1[], int arr2[]) {
        // code here
        int n = arr1.length;
        int m = arr2.length;
        HashSet<Integer>set = new HashSet<>();
        ArrayList<Integer>res = new ArrayList<>();
        for(int arr : arr1){
            set.add(arr);
        }
        
        for(int num : arr2){
            if(set.contains(num)){
                res.add(num);
                set.remove(num);
            }
        }
        return res;
        
      
    }
}


}