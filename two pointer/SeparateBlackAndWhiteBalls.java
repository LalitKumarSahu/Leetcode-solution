public class SeparateBlackAndWhiteBalls {
  
//Brute Force(nLogn)
class Solution {
    public long minimumSteps(String s){
    char arr[] = s.toCharArray();
    int left = 0;
    int right = arr.length-1;
    long count = 0;
    while(left < right){
        if(arr[left] == '1' && arr[right] == '0'){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            count += (right - left);
            left++;
            right--;
            
        }else{
            if(arr[left] == '0') left++;
            if(arr[right] == '1') right--;
            
        }
    }
    return count;
    }
}
}
