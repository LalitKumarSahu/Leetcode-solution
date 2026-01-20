import java.util.*;
class Solution {
    int maxLength(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;

        map.put(0, -1); 

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            if (map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }
        return len;
    }
}
