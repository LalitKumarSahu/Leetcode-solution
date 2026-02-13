// number of 1 jitne hai vo left me hoga fir zero aur ek last me 1 hoga eg = 11110001
// m-1 sorting and swap(NlogN) + N

 // m-2 number of  1 ka count and zero fir 1 one ko chhod ko left me 1 aur right me 0 fir ek last me 1

// m-3
class Solution {
   
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;
        char arr[] = s.toCharArray();

        while(left <= right){
            if(arr[left] == '1'){
                left++;
            }
            if(arr[right] == '0'){
              right--;
            }
            if(left < right && arr[left] == '0' && arr[right] =='1'){
            arr[left] = '1';
            arr[right] = '0';
            }
        }
        arr[right] = '0';
        arr[n-1] = '1';

        return new String(arr);

    }
}