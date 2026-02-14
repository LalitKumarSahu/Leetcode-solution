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

// m-2 using 2 pointer
// agar curr black ball hai to continue cur++ 
// agr cuur white ball hai to find the count and inc the last
// last ye track krega ki iske piche sab white ball hai
// curr == black to curr++
// jab curr = white to count = curr - last and last += 1
class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        int last = 0;        // ye track karega ki next 0 ko kis index par hona chahiye
        long swapCount = 0;  // total moves
        
        for (int curr = 0; curr < n; curr++) {
            if (s.charAt(curr) == '0') {
                // agar '0' mila, to usko left side (index = last) pe lana hai
                swapCount += (curr - last);  
                last++;  // agla 0 next position pe jayega
            }
        }
        return swapCount;
    }
}
}
